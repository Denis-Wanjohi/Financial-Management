package com.Final.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Final.bean.Student;

public class StudentDao {

	public StudentDao() {
		// TODO Auto-generated constructor stub
	}
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/fmanagement","root","light");
		return connection;
	}
	//login
	public String[][]  studentLogin(Student student) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement ps = connection.prepareStatement("select * from studentdetail where email = ? && password = ?");
		
		ps.setString(1,student.getEmail());
		ps.setString(2, student.getPassword());
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			
			List<String[]> resultList = new ArrayList<>();
//			while(rs.next()) {
				String firstname = rs.getString("firstname");
				String secondname = rs.getString("secondname");
				String identification_number = rs.getString("identification_number");
				String programme = rs.getString("programme");
				String registration_number = rs.getString("registration_number");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				String phone_number = rs.getString("phone_number");
				
				
				String[] row = {firstname,secondname,registration_number,identification_number,programme,gender,email,phone_number};
				resultList.add(row);
				 String[][] resultArray = resultList.toArray(new String[0][0]);
			
			
			return resultArray;
		}else {
			return null;
		}
	
	
	}
	
	//get student 
	public String[][]  studentByRgistarationNumber(String reg_number) throws ClassNotFoundException, SQLException {
		System.out.println("the received reg no is "+ reg_number);
		Connection connection = getConnection();
		PreparedStatement ps = connection.prepareStatement("select * from studentdetail where registration_number = ?");
		System.out.println("gotten the user");
		System.out.println("the sent reg no is "+ reg_number);
		ps.setString(1, reg_number);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			
			List<String[]> resultList = new ArrayList<>();
//			while(rs.next()) {
				String firstname = rs.getString("firstname");
				String secondname = rs.getString("secondname");
				String identification_number = rs.getString("identification_number");
				String programme = rs.getString("programme");
				String registration_number = rs.getString("registration_number");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				String phone_number = rs.getString("phone_number");
				
				
				String[] row = {firstname,secondname,registration_number,identification_number,programme,gender,email,phone_number};
				resultList.add(row);
				 String[][] resultArray = resultList.toArray(new String[0][0]);
			
			
			return resultArray;
		}else {
			System.out.println("null user @studentDao");
			return null;
		}
	}
	
	//register student
	
	public Boolean registerStudent(String firstname, 
									String secondname,
									String registration_number,
									String identification_number,
									String programme,
									String gender,
									String email,
									String password,
									String phone_number ) throws ClassNotFoundException, SQLException {
			
		
		String sql = "insert into studentdetail (firstname,secondname,registration_number,identification_number,programme,gender,email,password,phone_number) values(?,?,?,?,?,?,?,?,?);";
		Connection connection = getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, firstname);
		ps.setString(2, secondname);
		ps.setString(3, registration_number);
		ps.setString(4, identification_number);
		ps.setString(5, programme);
		ps.setString(6, gender);
		ps.setString(7, email);
		ps.setString(8, password);
		ps.setString(9, phone_number);
		
		int rowsAffected = ps.executeUpdate();
      
        if (rowsAffected > 0) {
            System.out.println("Student  registered successfully.");
            return true;
           
        } else {
            System.out.println("Student  registeredunsuccessful.");
            return false;
        }
	
		
		
	}
	public String[][] studentData() throws SQLException,ClassNotFoundException  {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		PreparedStatement ps = connection.prepareStatement("select "
				+ "studentdetail.firstname,studentdetail.secondname,studentdetail.registration_number,studentdetail.identification_number,studentdetail.gender,studentdetail.email,studentdetail.phone_number,studentdetail.programme, sum(transactions.amount) as amount"
				+ " from studentdetail "
				+ "inner join transactions "
				+ "on studentdetail.registration_number = transactions.registration_number "
				+ " group by studentdetail.id");
		
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {

		    List<String[]> resultList = new ArrayList<>();
		    do {
		        String firstname = rs.getString("firstname");
		        String secondname = rs.getString("secondname");
		        String registration_number = rs.getString("registration_number");
		        String identification_number = rs.getString("identification_number");
		        String gender = rs.getString("gender");
		        String email = rs.getString("email");
		        String phone_number = rs.getString("phone_number");
		        String programme = rs.getString("programme");
		        String amount = rs.getString("amount");
		        
		        
		        

		        String[] row = {firstname, secondname, registration_number, identification_number, gender,email,phone_number,programme,amount};
		        resultList.add(row);
		    } while (rs.next());

		    String[][] resultArray = resultList.toArray(new String[0][0]);
		   
		    return resultArray;
		} else {
			System.out.println("one");
		    return null;
		}
		
	
	}
	
	

}