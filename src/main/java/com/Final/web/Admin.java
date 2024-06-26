package com.Final.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.Final.Dao.Budget;
import com.Final.Dao.StaffDao;
import com.Final.Dao.StudentDao;

/**
 * Servlet implementation class Admin
 */
//@WebServlet(urlPatterns={"/Home","/registerStudent","/feeCollection","/expenseManagement","/budget","/expense","/payrollProcessing","/payroll","/studentDetails"})
@WebServlet(urlPatterns={"/staffDetails","/registerStaff","/proposedBudget","/studentsDetails","/registerStudents"})

public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StaffDao staffDao = new StaffDao();
	Budget budget = new Budget();
	StudentDao studentDao = new StudentDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getServletPath().equals("/registerStaff")) {
			System.out.println("staff registration");
			getServletContext().getRequestDispatcher("/Admin/RegisterStaff.jsp").forward(request, response);
		}else if(request.getServletPath().equals("/registerStudents")) {
			System.out.println("student registration");
			getServletContext().getRequestDispatcher("/Admin/RegisterStudent.jsp").forward(request, response);
		}else if (request.getServletPath().equals("/staffDetails")) {
			try {
				request.setAttribute("staff_details", staffDao.getAllStaffs());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getServletContext().getRequestDispatcher("/Admin/StaffDetails.jsp").forward(request, response);
		}else if (request.getServletPath().equals("/proposedBudget")) {
			try {
				request.setAttribute("budget", budget.budget());
				request.setAttribute("payroll", budget.payrolls());
//				request.setAttribute("", budget.payrolls());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getServletContext().getRequestDispatcher("/Admin/Budget.jsp").forward(request, response);
		}else if (request.getServletPath().equals("/studentsDetails")) {
			try {
				request.setAttribute("student_details", studentDao.studentData());
				System.out.println(studentDao.studentData()[0][0]);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getServletContext().getRequestDispatcher("/Admin/StudentDetails.jsp").forward(request, response);
		}
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getServletPath().equals("/feeCollection"))
		doGet(request, response);
	}

}
