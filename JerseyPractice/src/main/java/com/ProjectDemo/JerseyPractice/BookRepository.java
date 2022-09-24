package com.ProjectDemo.JerseyPractice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
	
	Connection con=null;
	
	//create constructor to register driver and ger connection object
	public BookRepository()  {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url= "jdbc:mysql://localhost:3306/restapipractice";
		String username="root";
		String password="90507284";
		try {
			con=DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Book> getBooks() {
		List<Book> books=new ArrayList<Book>();
		
		String query="Select * from book;";
		try {
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);  //select query
		
	    while(rs.next())
		{
		String BookData= rs.getInt(1)+" "+ rs.getString(2)+" "+rs.getInt(3);
		Book book=new Book();
		book.setId(rs.getInt(1));
		book.setName(rs.getString(2));
		book.setPages(rs.getInt(3));
		books.add(book);
		System.out.println(BookData);
	    }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return books;
	}
	
	public Book getBook(int id){
		String query="Select * from book where id=" + id;
		try {
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);  //select query
		if(rs.next()) {
		String BookData= rs.getInt(1)+" "+ rs.getString(2)+" "+rs.getInt(3);
		Book book=new Book();
		book.setId(rs.getInt(1));
		book.setName(rs.getString(2));
		book.setPages(rs.getInt(3));
		
		System.out.println(BookData);
		return book;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new Book();
	}

	public void createBook(Book b) {
		
		String query="Insert into restapipractice.book values(?,?,?)";
		try {
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1,b.getId() );
		st.setString(2,b.getName());
		st.setInt(3,b.getPages());
		
		st.executeUpdate();  //insert query
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
public void updateBook(Book b) {
		
		String query="update restapipractice.book set name=?,pages=? where id=?";
		try {
		PreparedStatement st=con.prepareStatement(query);
		
		st.setString(1,b.getName());
		st.setInt(2,b.getPages());
		st.setInt(3,b.getId() );
		
		st.executeUpdate();  //insert query
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

public void deleteBook(int id)
{
	String query="delete from restapipractice.book where id=?" ;
	try {
	PreparedStatement st=con.prepareStatement(query);
	st.setInt(1, id);
	st.executeUpdate();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	}
	


}
