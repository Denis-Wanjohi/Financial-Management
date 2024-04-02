package com.Final.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.OutputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import java.io.IOException;

import com.Final.Dao.Budget;
import com.Final.Dao.TransactionDao;

/**
 * Servlet implementation class Report
 */
@WebServlet(urlPatterns = {"/report","adminReport"})
public class Report extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TransactionDao transactionDao = new TransactionDao();
	Budget budget =  new Budget();


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		/*
		 * File file = new File("file.txt");
		 * 
		 * if (!file.exists()) { file.createNewFile(); }
		 * 
		 * try (FileWriter fileWriter = new FileWriter(file)) {
		 * fileWriter.write("Hello, World!"); fileWriter.append("\n");
		 * fileWriter.append("This is a new line."); fileWriter.append("\n");
		 * fileWriter.append("This is a new second line."); fileWriter.flush(); } catch
		 * (IOException e) { e.printStackTrace(); }
		 * System.out.println("file downloaded"); System.out.println("one");
		 */

		/*
		 * System.out.print("***********************");
		 * 
		 * String[][] transactions = null; try { transactions =
		 * transactionDao.studentTransaction("REG010"); } catch (ClassNotFoundException
		 * | SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * 
		 * for(String[] dataArray: transactions) {
		 * 
		 * for(String data : dataArray) { System.out.print(data); } }
		 * 
		 * 
		 * Workbook workbook = new XSSFWorkbook(); Sheet sheet =
		 * workbook.createSheet("Data"); String[][] data = {{"Name", "Age"}, {"John",
		 * "30"}, {"Alice", "25"}}; int rowNum = 0; for (String[] rowData : data) { Row
		 * row = sheet.createRow(rowNum++); int colNum = 0; for (String cellData :
		 * rowData) { row.createCell(colNum++).setCellValue(cellData); } }
		 * 
		 * // Write the Excel workbook to the response output stream
		 * response.setContentType(
		 * "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		 * OutputStream outputStream = response.getOutputStream();
		 * workbook.write(outputStream); outputStream.close(); workbook.close();
		 * 
		 * // Send a response to the client
		 * response.getWriter().println("Excel file created successfully!");
		 */
		if(request.getServletPath().equals("/report")) {
			
		
		System.out.print("**********************");
		String registration_number = (String) session.getAttribute("registration_number");
		String fileName = registration_number+".txt";
        String filePath = "C:\\Users\\User\\Desktop\\reportOne.txt";

        //inputing data from databses
        //this is a .txt example
        
        File file = new File(filePath);
        FileWriter writer = new FileWriter(file);
        writer.write("\t\t\t SUMMARY REPORT\n");
//        String registration_number = (String) session.getAttribute("registration_number");
        try {
			String[][] student_transactions = transactionDao.studentTransaction(registration_number);
			for(String[] data : (String[][]) student_transactions) {
				writer.write("Registration No. "+data[0]);
				writer.write("\nAccount No. "+data[1]);
				writer.write("\nBank: "+data[2]);
				writer.write("\nTransaction Code. "+data[3]);
				writer.write("\nDate: "+data[4]);
				writer.write("\nAmount "+data[5]);
				writer.write("\n\n\n");
				System.out.println();
				System.out.println("Registration No. "+data[0]);
				System.out.println("Account No. "+data[1]);
				System.out.println("Bank: "+data[2]);
				System.out.println("Transaction Code. "+data[3]);
				System.out.println("Date: "+data[4]);
				System.out.println("Amount "+data[5]);
				System.out.println("**ends here**");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        writer.close();
        // Set the appropriate headers for the response
        
        response.setContentType("text/plain");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

        // Open the input stream for the file
        FileInputStream inputStream = new FileInputStream(filePath);
       

        // Get the output stream for the response
        OutputStream outputStream = response.getOutputStream();

        // Write the contents of the file to the output stream
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        // Close the input and output streams
        inputStream.close();
        outputStream.close();
        
		/*
		 * //this a excel file Workbook workbook = new XSSFWorkbook(); Sheet sheet =
		 * workbook.createSheet("Student Data"); Row row = sheet.createRow(0); Cell cell
		 * = row.createCell(0); cell.setCellValue("Name");
		 * 
		 * cell = row.createCell(1); cell.setCellValue("Age");
		 * 
		 * cell = row.createCell(2); cell.setCellValue("Gender");
		 * 
		 * cell = row.createCell(3); cell.setCellValue("Grade");
		 * 
		 * FileOutputStream outputStream = new FileOutputStream("student_data.xlsx");
		 * workbook.write(outputStream); outputStream.close();
		 */
        System.out.print("**********************");
		}else if(request.getServletPath().equals("/adminReport")) {
//			String[][] budget = budget.;
			
			String fileName = "finance.txt";
	        String filePath = "C:\\Users\\User\\Desktop\\reportOne.txt";

	        //inputing data from databses
	        //this is a .txt example
	        
	        File file = new File(filePath);
	        FileWriter writer = new FileWriter(file);
	        writer.write("\t\t\t FINANCE REPORT\n");
//	        String registration_number = (String) session.getAttribute("registration_number");
	        try {
			
				for(String[] data : (String[][]) budget.budget()) {
					writer.write("Mess. "+data[0]);
					writer.write("\nLibrary. "+data[1]);
					writer.write("\nSalaries: "+data[2]);
					writer.write("\nMaintenance. "+data[3]);
					writer.write("\nGames: "+data[4]);
					writer.write("\nTuition "+data[5]);
					writer.write("\nFarming "+data[6]);
					writer.write("\nMiscellaneous  "+data[7]);
			
					writer.write("\n\n\n");
					System.out.println();
					System.out.println("Registration No. "+data[0]);
					System.out.println("Account No. "+data[1]);
					System.out.println("Bank: "+data[2]);
					System.out.println("Transaction Code. "+data[3]);
					System.out.println("Date: "+data[4]);
					System.out.println("Amount "+data[5]);
					System.out.println("**ends here**");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        writer.close();
	        // Set the appropriate headers for the response
	        
	        response.setContentType("text/plain");
	        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

	        // Open the input stream for the file
	        FileInputStream inputStream = new FileInputStream(filePath);
	       

	        // Get the output stream for the response
	        OutputStream outputStream = response.getOutputStream();

	        // Write the contents of the file to the output stream
	        byte[] buffer = new byte[4096];
	        int bytesRead;
	        while ((bytesRead = inputStream.read(buffer)) != -1) {
	            outputStream.write(buffer, 0, bytesRead);
	        }

	        // Close the input and output streams
	        inputStream.close();
	        outputStream.close();
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("two");
		doGet(request, response);
	}

}
