package com.ProjectDemo.JerseyPractice;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Book {
	
	private int id;
	private String name;
	private int pages;
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPages() {
		return pages;
	}


	public void setPages(int pages) {
		this.pages = pages;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", pages=" + pages + "]";
	}
	
	
	

}
