package com.Final.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Final.bean.Staff;

public class StaffDao {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/fmanagement","root","light");
		return connection;
	}
	
	
	public String[][] staffLogin(String Useremail,String password) throws SQLException, ClassNotFoundException{
		Connection connection = getConnection();
		PreparedStatement ps = connection.prepareStatement("select * from staff_details where email = ? && password = ?");
		
		ps.setString(1,Useremail);
		ps.setString(2,password);
		System.out.println("staff");
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			
			List<String[]> resultList = new ArrayList<>();
//			while(rs.next()) {
				String name = rs.getString("name");
				String identification_number = rs.getString("identification_number");
				String staff_number = rs.getString("staff_number");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				String phone_number = rs.getString("phone_number");
				String type = rs.getString("is_admin");
				
				
				String[] row = {name,staff_number,identification_number,gender,email,phone_number,type};
				resultList.add(row);
				 String[][] resultArray = resultList.toArray(new String[0][0]);
			return resultArray;
		}else {
			System.out.println("staff array is  empty");
			return null;
		}
	}
	
	public String[][] staffByEmail(String Useremail) throws SQLException, ClassNotFoundException{
		Connection connection = getConnection();
		PreparedStatement ps = connection.prepareStatement("select * from staff_details where email = ?");
		
		ps.setString(1,Useremail);
		
		System.out.println("staff");
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			
			List<String[]> resultList = new ArrayList<>();
//			while(rs.next()) {
				String name = rs.getString("name");
		
				String identification_number = rs.getString("identification_number");
			
				String staff_number = rs.getString("staff_number");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				String phone_number = rs.getString("phone_number");
				
				
				String[] row = {name,staff_number,identification_number,gender,email,phone_number};
				resultList.add(row);
				 String[][] resultArray = resultList.toArray(new String[0][0]);
			
			
			return resultArray;
		}else {
			System.out.println("staff array is  empty");
			return null;
		}
	}
	
	public StaffDao() {
		// TODO Auto-generated constructor stub
	}


	public String [][] getAllStaffs() throws SQLException , ClassNotFoundException{
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		PreparedStatement ps = connection.prepareStatement("select * from staff_details");
	
	
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			
			List<String[]> resultList = new ArrayList<>();
			while(rs.next()) {
				String name = rs.getString("name");
				String identification_number = rs.getString("identification_number");
				String staff_number = rs.getString("staff_number");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				String phone_number = rs.getString("phone_number");
				String type = rs.getString("is_admin");
				
				
				String[] row = {name,staff_number,identification_number,gender,email,phone_number,type};
				resultList.add(row);
			}
				String[][] resultArray = resultList.toArray(new String[0][0]);
			
			
			return resultArray;
		}else {
			System.out.println("staff array is  empty");
			return null;
		}
	
	}

}
