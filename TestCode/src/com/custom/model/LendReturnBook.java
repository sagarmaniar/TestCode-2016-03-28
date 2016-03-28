package com.custom.model;

import java.util.Date;

public class LendReturnBook {

	private int memberId;
	private String bookId;
	private Date dateOfIssue;
	private Date dateOfReturn;
	
	public LendReturnBook(){
		this.bookId=bookId;
		this.memberId=memberId;
		this.dateOfIssue=dateOfIssue;
		this.dateOfReturn=dateOfReturn;
	}
	public LendReturnBook(int memberId,String bookId,Date dateOfIssue,Date dateOfReturn){
		this.bookId=bookId;
		this.memberId=memberId;
		this.dateOfIssue=dateOfIssue;
		this.dateOfReturn=dateOfReturn;	
	}
	
	public int getMemberId(){
		return memberId;
	}
	public void setMemberId(int memberId){
		this.memberId=memberId;
	}
	
	public String getBookId(){
		return bookId;
	}
	public void setBookId(String bookId){
		this.bookId=bookId;
	}
	
	public Date getDateOfIssue(){
		return dateOfIssue;
	}
	public void setDateOfIssue(Date dateOfIssue){
		this.dateOfIssue=dateOfIssue;
	}
	public Date getDateOfReturn(){
		return dateOfReturn;
	}
	public void setDateOfReturn(Date dateOfReturn){
		this.dateOfReturn=dateOfReturn;
	}
}
