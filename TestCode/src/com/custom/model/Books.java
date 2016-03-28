package com.custom.model;

public class Books {
	
	private String bookId;
	private String bookTitle;
	private String bookAuthor;
	private String availability;
	private double bookPrice;
	
	public Books(){
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor=bookAuthor;
		this.availability=availability;
		this.bookPrice=bookPrice;
	}
	
	public Books(String bookId,String bookTitle, String bookAuthor,String availability, double bookPrice){
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor=bookAuthor;
		this.availability=availability;
		this.bookPrice=bookPrice;
	}
 
	
 
 
	public String getBookId(){
		return bookId;
	}
	public void setBookId(String bookId){
		this.bookId=bookId;
	}


	public String getBookTitle(){
		return bookTitle;
	}
	public void setBookTitle(String bookTitle){
		this.bookTitle=bookTitle;
	}
	
	public String getBookAuthor(){
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor){
		this.bookAuthor=bookAuthor;
	}
	
	public String getAvailability(){
		return availability;
	}
	public void setAvailability(String availability){
		this.availability=availability;
	}
	
	public double getBookPrice(){
		return bookPrice;
	}
	public void setBookPrice(double bookPrice){
		this.bookPrice=bookPrice;
	}
}
