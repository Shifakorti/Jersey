package com.ProjectDemo.JerseyPractice;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("bookresource")
public class BookResourse {

	BookRepository repo= new BookRepository();

	    /**
	     * Method handling HTTP GET requests. The returned object will be sent
	     * to the client as "text/plain" media type.
	     *
	     * @return String that will be returned as a text/plain response.
	     */
	    @GET
	    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	    public List<Book> getBooks() {
	        return repo.getBooks();
	    }
	    
	    @GET
	    @Path("book/{id}")
	    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	    public Book getBook(@PathParam("id") int id) {
	        return repo.getBook(id);
	    }
	    
	    @POST
	    @Path("book")
	    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	    public Book createBook(Book b)
	    {
	    	repo.createBook(b);
	    	return b;
	    }
	    
	    @PUT
	    @Path("book")
	    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	    public Book updateBook(Book b)
	    {
	    	if(repo.getBook(b.getId()).getId()==0)
	    	{
	    		repo.createBook(b);
	    	}
	    	else
	    	{
	    	repo.updateBook(b);
	    	}
	    	return b;
	    }
	    
	    @DELETE
	    @Path("book/{id}")
	    public Book deleteBook(@PathParam ("id") int id) {
	    	Book book=repo.getBook(id);
	    	if(book.getId()!=0)
	    	{
	    	repo.deleteBook(id);
	    	}
	    	return book;
	    }
	}


