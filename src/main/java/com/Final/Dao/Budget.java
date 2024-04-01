package com.Final.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Budget {

	public Budget() {
		// TODO Auto-generated constructor stub
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/fmanagement","root","light");
		return connection;
	}
	
	public String[][] budget() throws ClassNotFoundException, SQLException{
		Connection connection = getConnection();
		 Statement stmt = connection.createStatement();
		 
		 ResultSet rs = stmt.executeQuery("select * from Budget");
		 if(rs.next()) {
				
				List<String[]> resultList = new ArrayList<>();
//				while(rs.next()) {
					String Mess = rs.getString("Mess");
					String Library = rs.getString("Library");
					String Salaries = rs.getString("Salaries");
					String Maintenance = rs.getString("Maintenance");
					String Games = rs.getString("Games");
					String Tuition = rs.getString("Tuition");
					String Farming = rs.getString("Farming");
					String Miscellaneous = rs.getString("Miscellaneous");
					
					
					String[] row = {Mess,Library,Salaries,Maintenance,Games,Tuition,Farming,Miscellaneous};
					resultList.add(row);
					 String[][] resultArray = resultList.toArray(new String[0][0]);
				
				
				return resultArray;
			}else {
				return null;
			}

	}
	
	public Boolean updateBudget(String expense,String amount) throws ClassNotFoundException, SQLException {
			
		Connection connection = getConnection();
		String query = String.format("update Budget set `%s` = ? where id = 1;", expense);
		PreparedStatement ps = connection.prepareStatement(query);
		System.out.println("the added amount is:" + amount);
		ps.setString(1, amount);
		int rowsAffected = ps.executeUpdate();	
		System.out.println("expense");
		ps.close();
		/*
		 * double balance = 0; balance = (double) getTotal() -
		 * Double.parseDouble(amount); PreparedStatement psTotal =
		 * connection.prepareStatement("update Budget set Total = ? where id = 1;");
		 * psTotal.setDouble(1, balance); psTotal.executeUpdate(); psTotal.close();
		 */
		if(rowsAffected > 0) {
			connection.close();
			return true;
		}else {
			return false;
		}
	
	}

	public Object getAllocatedTotal() throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();
		
		PreparedStatement st = connection.prepareStatement("SELECT SUM( Mess + Library + Salaries + Maintenance + Games + Tuition + Farming + Miscellaneous ) AS Total FROM Budget WHERE id = 1;");
		
		ResultSet resultSet = st.executeQuery();
		double total = 0;
		while (resultSet.next()) {
		  total = resultSet.getDouble("Total");
		}
		resultSet.close();
		st.close();
		
		String sql = "update Budget set AllocatedMoney = ? where id = 1;";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setDouble(1, total);
		ps.executeUpdate();
		ps.close();
		
		/*
		 * PreparedStatement psTotal =
		 * connection.prepareStatement("update Budget set Total = ? where id = 1;");
		 * psTotal.setDouble(1, 100000 - total); psTotal.executeUpdate();
		 * psTotal.close();
		 */
		
		connection.close();
		
		System.out.println("this the allocated money in the database  "+total);
		return total;
	}

	public Object getTotal() throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();
		
		PreparedStatement st = connection.prepareStatement("SELECT Total FROM Budget WHERE id = 1;");
		
		ResultSet resultSet = st.executeQuery();
		double total = 0;
		while (resultSet.next()) {
		  total = resultSet.getDouble("Total");
		  System.out.println(" Actual Total: " + total);
		}

		resultSet.close();
		st.close();
		connection.close();
		
		return total;
	}
	
	public Object getBalance() throws SQLException, ClassNotFoundException {
		
		
		Connection connection = getConnection();
		
		PreparedStatement st = connection.prepareStatement("SELECT SUM( Mess + Library + Salaries + Maintenance + Games + Tuition + Farming + Miscellaneous ) AS Total FROM Budget WHERE id = 1;");
		
		ResultSet resultSet = st.executeQuery();
		double allocated = 0;
		while (resultSet.next()) {
			allocated = resultSet.getDouble("Total");
		}
		resultSet.close();
		st.close();
		
		double balance = (double) getTotal() -  allocated;
		
		
		 System.out.println("The Actual Total in the database: " + balance);
		
		
		
		return balance;
	}

	public  String[][] payrolls() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		Statement stmt = connection.createStatement();

		ResultSet rs = stmt.executeQuery("select * from payrolls");
		if (rs.next()) {

		    List<String[]> resultList = new ArrayList<>();
		    do {
		        String workGroup = rs.getString("workGroup");
		        String number_of_workers = rs.getString("number_of_workers");
		        String payroll_period = rs.getString("payroll_period");
		        String amount_per_worker = rs.getString("amount_per_worker");
		        String total_pay = rs.getString("total_pay");
		        

		        String[] row = {workGroup, number_of_workers, payroll_period, amount_per_worker, total_pay};
		        resultList.add(row);
		    } while (rs.next());

		    String[][] resultArray = resultList.toArray(new String[0][0]);
		    return resultArray;
		} else {
		    return null;
		}
	}

	public Boolean updatePayroll(String workGroup,String workers, String period, String amount) throws SQLException,ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		System.out.println(period);
		String str = "update  payrolls set number_of_workers = %s, payroll_period = '%s',amount_per_worker  = %s , total_pay = %s * %s where workGroup = ?;";
		String sql  = String.format(str, workers,period,amount,workers,amount);
		PreparedStatement ps =  conn.prepareStatement(sql);
		ps.setString(1, workGroup);
		int rowsAffected = ps.executeUpdate();
		if(rowsAffected > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	
}
