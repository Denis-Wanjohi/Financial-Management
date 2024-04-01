package com.Final.bean;

public class FeePayment {

	public int id;
	public String regno;
	public String bank;
	public int account_no;
	public int amount;
	public String transaction_code;
	public int  feeBalance;
	public String feePaymentConfirmation;
	
	
	
	public FeePayment(String regno, String bank, int account_no, int amount, String transaction_code, int feeBalance,
			String feePaymentConfirmation) {
		super();
		this.regno = regno;
		this.bank = bank;
		this.account_no = account_no;
		this.amount = amount;
		this.transaction_code = transaction_code;
		this.feeBalance = feeBalance;
		this.feePaymentConfirmation = feePaymentConfirmation;
	}



	public FeePayment(int id, String regno, String bank, int account_no, int amount, String transaction_code,
			int feeBalance, String feePaymentConfirmation) {
		super();
		this.id = id;
		this.regno = regno;
		this.bank = bank;
		this.account_no = account_no;
		this.amount = amount;
		this.transaction_code = transaction_code;
		this.feeBalance = feeBalance;
		this.feePaymentConfirmation = feePaymentConfirmation;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getRegno() {
		return regno;
	}



	public void setRegno(String regno) {
		this.regno = regno;
	}



	public String getBank() {
		return bank;
	}



	public void setBank(String bank) {
		this.bank = bank;
	}



	public int getAccount_no() {
		return account_no;
	}



	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}



	public int getAmount() {
		return amount;
	}



	public void setAmount(int amount) {
		this.amount = amount;
	}



	public String getTransaction_code() {
		return transaction_code;
	}



	public void setTransaction_code(String transaction_code) {
		this.transaction_code = transaction_code;
	}



	public int getFeeBalance() {
		return feeBalance;
	}



	public void setFeeBalance(int feeBalance) {
		this.feeBalance = feeBalance;
	}



	public String getFeePaymentConfirmation() {
		return feePaymentConfirmation;
	}



	public void setFeePaymentConfirmation(String feePaymentConfirmation) {
		this.feePaymentConfirmation = feePaymentConfirmation;
	}



	public FeePayment() {
		// TODO Auto-generated constructor stub
	}

}
