package com.Final.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Final.bean.Transactions;

public class TransactionDao {
	Transactions transaction = new Transactions();

	public TransactionDao() {
		// TODO Auto-generated constructor stub
		 
	}
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/fmanagement","root","light");
		return connection;
	}
	
	public String[][] studentTransaction(String reg_number) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement ps = connection.prepareStatement("select * from transactions where registration_number = ?");
		
		ps.setString(1,reg_number);
		
		ResultSet rs = ps.executeQuery();
		

			
			List<String[]> transactions = new ArrayList<>();
			while(rs.next()) {
				String registration_number = rs.getString("registration_number");
				String bank = rs.getString("bank");
				String account_number = rs.getString("account_number");
				String transaction_id = rs.getString("transaction_id");
				String date = rs.getString("date");
				String amount = rs.getString("amount");
		
				
				
				String[] row = {registration_number,account_number,bank,transaction_id,date,amount};
				transactions.add(row);
			}
				 
				 String[][] allTransactions = transactions.toArray(new String[transactions.size()][]);	 
			
			return allTransactions;
	
		
	}
	public double totalAmount(String reg_number) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement ps = connection.prepareStatement("select sum(amount) as amount from transactions where registration_number = ?;");
		
		ps.setString(1,reg_number);
		
		ResultSet rs = ps.executeQuery();
		double totalAmount = 0.0;
		if(rs.next()) {
			return rs.getDouble("amount");
		}
		return 0;
	}
	
	public  String[][] makePayments(Transactions transactions) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		System.out.println("one");
		String sql = "INSERT INTO transactions (account_number, registration_number,bank, transaction_id,date,amount) VALUES (?, ?, ?, ?, ?, ?)";
	    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	      
	        preparedStatement.setString(1, transactions.getAccount_number());
	        preparedStatement.setString(2, transactions.getRegistrationNumber());
	        preparedStatement.setString(3, transactions.getBank());
	        preparedStatement.setString(4, transactions.getTransactionId());
	        preparedStatement.setDate(5, transactions.getDate());
	        preparedStatement.setDouble(6, transactions.getAmount());
	       
	        
	     // Print out the values being sent to the database
	        System.out.println("Data being sent to the database:");
	        System.out.println("Account Number: " + transactions.getAccount_number());
	        System.out.println("Registration Number: " + transactions.getRegistrationNumber());
	        System.out.println("Bank: " + transactions.getBank());
	        System.out.println("Transaction ID: " + transactions.getTransactionId());
	        System.out.println("Date: " + transactions.getDate());
	        System.out.println("Amount: " + transactions.getAmount());

	        int rowsAffected = preparedStatement.executeUpdate();
	        System.out.println(transactions.getRegistrationNumber());
	        if (rowsAffected > 0) {
	            System.out.println("Payment record inserted successfully.");
	            return studentTransaction(transactions.getRegistrationNumber());
	           
	        } else {
	            System.out.println("Payment record insertion unsuccessful.");
	            return null;
	        }
	    }
		
	}
	public String[][] confirmPayment(String transaction_code , String reg_id, String userbank) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		 System.out.println("checking out");
		Connection connection = getConnection();
		String sql = "SELECT * FROM transactions where transaction_id = ? &&  registration_number = ? && bank = ?;";
		//select * from transactions where transaction_id="CPBTY678" && registration_number="REG001" && bank="Co-operative Bank of Kenya Ltd";
		 System.out.println(transaction_code);
		 System.out.println(reg_id);
		 System.out.println(userbank);
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, transaction_code);
		ps.setString(2, reg_id);
		ps.setString(3, userbank);
		
		ResultSet rs = ps.executeQuery();
		 System.out.println("Confirmed2");
		if(rs.next()) {
			 System.out.println("Confirmed3");
			List<String[]> resultList = new ArrayList<>();
//			while(rs.next()) {
				String account_number = rs.getString("account_number");
				String bank = rs.getString("bank");
				String transaction_id = rs.getString("transaction_id");
				String registration_number = rs.getString("registration_number");
				String amount = rs.getString("amount");
				String date = rs.getString("date");
			
				
				String[] row = {account_number,bank,registration_number,transaction_id,amount,date};
				resultList.add(row);
				 String[][] resultArray = resultList.toArray(new String[0][0]);
				 System.out.println("Confirmed");
			
			
			return resultArray;
		}else {
			 System.out.println("Confirmed4");
			return null;
		}		
		
	}
	
}
