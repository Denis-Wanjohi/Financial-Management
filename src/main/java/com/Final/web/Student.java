package com.Final.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.Final.Dao.StudentDao;
import com.Final.Dao.TransactionDao;
import com.Final.bean.Transactions;

/**
 * Servlet implementation class Student
 */
@WebServlet(urlPatterns={"/payments","/Student/Home"})
public class Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Transactions transactions = new Transactions();
	TransactionDao transactionsDao = new TransactionDao();


	
	StudentDao studentDao = new StudentDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(15*60);
		if(request.getServletPath().equals("/payments")) {
			getServletContext().getRequestDispatcher("/Student/makePayments.jsp").forward(request, response);
//			response.getWriter().append("Served at: ").append(request.getContextPath());
		}else if (request.getServletPath().equals("/Student/Home")) {
			try {
//				request.setAttribute("student_data", session.getAttribute("stude"));
				System.out.println("registration no is "+session.getAttribute("registration_number"));
				String registration_number = (String) session.getAttribute("registration_number");
				/*
				 * Cookie[] cookies = request.getCookies(); for (int i = 0; i < cookies.length;
				 * i++) { System.out.println(cookies[i].getValue()); if
				 * (cookies[i].getName().equals("registration_number")) { registration_number =
				 * cookies[i].getValue(); break; } }
				 */
			
				System.out.println("the outcome is "+ transactionsDao.totalAmount(registration_number));
				System.out.println("getting the student");
				request.setAttribute("student_data", studentDao.studentByRgistarationNumber(registration_number));
				request.setAttribute("transactions_data", transactionsDao.studentTransaction(registration_number));
				request.setAttribute("total_amount", transactionsDao.totalAmount(registration_number));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getServletContext().getRequestDispatcher("/Student/studentLoginAction.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		 File file = new File("C:\\Users\\User\\Desktop\\fileReports.txt");
		/*File file = new File("C:\\Users\\User\\Desktop\\fileReports.txt");
		FileInputStream inputStream = new FileInputStream(file);
		
		String fileName = "ReportsOnly";
		
		response.setHeader("Content-Disposition","attachment; filename"+ fileName);
		response.setContentType("application/octet-stream");
		
		
		  
		try (ServletOutputStream outputStream = response.getOutputStream()) {
		    byte[] buffer = new byte[1024];
		    int length;
		    while ((length = inputStream.read(buffer)) > 0) {
		        outputStream.write(buffer, 0, length);
		    }*/
		File file = new File("C:\\Users\\User\\Desktop\\fileReports.txt");

		/*
		 * if (file.exists() && file.isFile()) { FileInputStream inputStream = new
		 * FileInputStream(file);
		 * 
		 * String fileName = "fileReports.txt";
		 * 
		 * response.setHeader("Content-Disposition", "attachment; filename=" +
		 * fileName); response.setContentType("application/octet-stream");
		 * 
		 * try (ServletOutputStream outputStream = response.getOutputStream()) { byte[]
		 * buffer = new byte[1024]; int length; while ((length =
		 * inputStream.read(buffer)) > 0) { outputStream.write(buffer, 0, length); }
		 * 
		 * inputStream.close(); outputStream.flush(); } catch (IOException e) {
		 * e.printStackTrace(); } }
		 */
		
	        if (!file.exists()) {
	            file.createNewFile();
	        }

	        try (FileWriter fileWriter = new FileWriter(file)) {
	            fileWriter.write("Hello, World!");
	            fileWriter.append("\n");
	            fileWriter.append("move on");
	            fileWriter.flush();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        System.out.println("file downloaded");
	        String filePath = "C:/Users/User/Desktop/report.txt";
	        String data = "what we burn we get it as we move on";
	        
	        FileWriter writer = new FileWriter(filePath);
	        writer.write(data);
	        System.out.println("report is written");
		String registration_number = request.getParameter("registration_number");
		String bank = request.getParameter("bank");
		String account_number = request.getParameter("account_number");
		String amount = request.getParameter("amount");
		String transaction_code = request.getParameter("transaction_code");
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);
//        java.sql.Date sqlDate = Date.valueOf(formattedDate);
		
		//String sql = "INSERT INTO transactions (account_number, registration_number,bank, transaction_id,date,amount) VALUES (?, ?, ?, ?, ?, ?)";
		transactions.setAccount_number(account_number);
		transactions.setAmount(Double.parseDouble(amount));
		transactions.setBank(bank);
		transactions.setTransactionId(transaction_code);
		transactions.setDate(sqlDate);
		transactions.setRegistrationNumber(registration_number);
		
		try {
			String[][] confirmation = transactionsDao.makePayments(transactions);
			if(confirmation  != null) {
				request.setAttribute("student_data", studentDao.studentByRgistarationNumber(registration_number));
				request.setAttribute("transactions_data", transactionsDao.studentTransaction(registration_number));
				request.setAttribute("total_amount", transactionsDao.totalAmount(registration_number));
				System.out.println(transactionsDao.totalAmount(registration_number));
				getServletContext().getRequestDispatcher("/Student/studentLoginAction.jsp").forward(request, response);
				
			}else { 
				request.setAttribute("error", "please fill in correct values");
				doGet(request, response);
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	
	}

	}
