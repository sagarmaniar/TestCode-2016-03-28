package com.custom.model;

import java.util.Date;

public class Members {

	
	private String memberName;
	private String memberAddress;
	private String memberMailId;
	private String memberPhone;
	private String memberType;
	private Date dateOfIssue;
	private Date dateOfExpiry;
	private int memberId;
	
	public Members(String memberName,String memberAddress,String memberMailId,String memberPhone,String memberType, Date dateOfIssue,Date dateOfExpiry,int memberId){
		this.memberName=memberName;
		this.memberAddress=memberAddress;
		this.memberMailId=memberMailId;
		this.memberPhone=memberPhone;
		this.memberType=memberType;
		this.dateOfIssue=dateOfIssue;
		this.dateOfExpiry=dateOfExpiry;
		this.memberId=memberId;
		
	}
	public Members() {
		
		this.memberName=memberName;
		this.memberAddress=memberAddress;
		this.memberMailId=memberMailId;
		this.memberPhone=memberPhone;
		this.memberType=memberType;
		this.dateOfIssue=dateOfIssue;
		this.dateOfExpiry=dateOfExpiry;
		this.memberId=memberId;
	}
	public String getMemberName(){
		return memberName;
	}
	public void setMemberName(String memberName){
		this.memberName=memberName;
	}
	
	public String getMemberAddress(){
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress){
		this.memberAddress=memberAddress;
	}
	
	public String getMemberMailId(){
		return memberMailId;
	}
	public void setMemberMailId(String memberMailId){
		this.memberMailId=memberMailId;
	}
	
	public String getMemberPhone(){
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone){
		this.memberPhone=memberPhone;
	}
	
	public String getMemberType(){
		return memberType;
	}
	public void setMemberType(String memberType){
		this.memberType=memberType;
	}
	

	public Date getDateOfIssue(){
		return dateOfIssue;
	}
	public void setDateOfIssue(Date dateOfIssue){
		this.dateOfIssue=dateOfIssue;
	}
	
	public Date getDateOfExpiry(){
		return dateOfExpiry;
	}
	public void setDateOfExpiry(Date dateOfExpiry){
		this.dateOfExpiry=dateOfExpiry;
	}
	
	public int getMemberId(){
		return memberId;
	}
	public void setMemberId(int memberId){
		this.memberId=memberId;
	}
}
