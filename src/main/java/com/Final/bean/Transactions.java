package com.Final.bean;

import java.sql.Date;
import java.time.LocalDate;

public class Transactions {
	  	private   int id;
	    private String registrationNumber;
	    private String bank;
	    private String account_number;
	    private String transactionId;
	    private Date date;
	    private double amount;
	    
	    
	    
	   


	public Transactions(String registrationNumber, String bank, String account_number, String transactionId,
			Date date, double amount) {
			super();
			this.registrationNumber = registrationNumber;
			this.bank = bank;
			this.account_number = account_number;
			this.transactionId = transactionId;
			this.date = date;
			this.amount = amount;
		}






	public Transactions(int id, String registrationNumber, String bank, String account_number, String transactionId,
			Date date, double amount) {
			super();
			this.id = id;
			this.registrationNumber = registrationNumber;
			this.bank = bank;
			this.account_number = account_number;
			this.transactionId = transactionId;
			this.date = date;
			this.amount = amount;
		}






	public int getId() {
		return id;
	}






	public void setId(int id) {
		this.id = id;
	}






	public String getRegistrationNumber() {
		return registrationNumber;
	}






	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}






	public String getBank() {
		return bank;
	}






	public void setBank(String bank) {
		this.bank = bank;
	}






	public String getAccount_number() {
		return account_number;
	}






	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}






	public String getTransactionId() {
		return transactionId;
	}






	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}






	public Date getDate() {
		return date;
	}






	public void setDate(Date sqlDate) {
		this.date = sqlDate;
	}






	public double getAmount() {
		return amount;
	}






	public void setAmount(double amount) {
		this.amount = amount;
	}






	public Transactions() {
		// TODO Auto-generated constructor stub
	}

}
