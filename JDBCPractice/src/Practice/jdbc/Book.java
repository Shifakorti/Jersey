package Practice.jdbc;

import java.sql.*;

public class Book {
	
	public static void main(String[] args) throws Exception
	{
		String url= "jdbc:mysql://localhost:3306/jerseypractice";
		String username="root";
		String password="90507284";
		int name=2;
		String bookName="java";
		int pages=700;
		float size=7;
		int bookId=9; //unique
		
	
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,username,password);
		
		
		
		
		/**
		String query="Select * from book;";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);  //select query
		rs.next();
	    while(rs.hashCode());
		{
		String BookData= rs.getInt(1)+" "+ rs.getString(2);
		System.out.println(BookData);
	    }
	     **/
		
	   
		/**
		String query="Insert into jerseypractice.book values(" +"'" + name + "','"+bookName+ "','"+pages + "','"+size + "','"+bookId +"')";
		String query="INSERT INTO `jerseypractice`.`book` (`Name`, `BookName`, `Pages`, `Size`, `BookId`) VALUES (`name`, `bookName`, `pages`, `size`, `bookId`)";
		Statement st=con.createStatement();
		int count=executeUpdate(query) --insert query
		System.out.println(count);
		**/
		
		/**
		 String query="Insert into jerseypractice.book values(?,?,?,?,?)";
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1, name);
		st.setString(2,bookName);
		st.setInt(3, pages);
		st.setFloat(4, size);
		st.setInt(5, bookId);
		int count=st.executeUpdate();  //insert query
		System.out.println(count);
		 **/
		//
		
		
		st.close();
		con.close();
		
	}

}
