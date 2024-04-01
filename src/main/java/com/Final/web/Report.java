package com.Final.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

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

import com.Final.Dao.TransactionDao;

/**
 * Servlet implementation class Report
 */
@WebServlet(urlPatterns="/report")
public class Report extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TransactionDao transactionDao = new TransactionDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Report() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		System.out.print("***********************");
		/*
		 * String[][] transactions = null; try { transactions =
		 * transactionDao.studentTransaction("REG010"); } catch (ClassNotFoundException
		 * | SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * 
		 * for(String[] dataArray: transactions) {
		 * 
		 * for(String data : dataArray) { System.out.print(data); } }
		 */
		
		Workbook workbook = new XSSFWorkbook();
	    Sheet sheet = workbook.createSheet("Data");
	    String[][] data = {{"Name", "Age"}, {"John", "30"}, {"Alice", "25"}};
	    int rowNum = 0;
	    for (String[] rowData : data) {
	        Row row = sheet.createRow(rowNum++);
	        int colNum = 0;
	        for (String cellData : rowData) {
	            row.createCell(colNum++).setCellValue(cellData);
	        }
	    }

	    // Write the Excel workbook to the response output stream
	    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	    OutputStream outputStream = response.getOutputStream();
	    workbook.write(outputStream);
	    outputStream.close();
	    workbook.close();

	    // Send a response to the client
	    response.getWriter().println("Excel file created successfully!");
			System.out.print("**********************");
        }

      
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("two");
		doGet(request, response);
	}

}
