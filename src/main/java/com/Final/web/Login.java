package com.Final.web;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import com.Final.bean.Staff;
import com.Final.bean.Student;
import com.Final.bean.Transactions;
import com.Final.Dao.StaffDao;
import com.Final.Dao.StudentDao;
import com.Final.Dao.TransactionDao;

/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns= {"/login/student","/login/staff","/login/admin","/login/regularStaff"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;
	private StaffDao staffDao = new StaffDao();
	private   TransactionDao transactionDao = new TransactionDao();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		studentDao = new StudentDao();	
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		if(request.getServletPath().equals("/login/student")) {
			getServletContext().getRequestDispatcher("/Student/login.jsp").forward(request, response);
		}else if(request.getServletPath().equals("/login/staff") ) {
			getServletContext().getRequestDispatcher("/Staff/login.jsp").forward(request, response); 
		}else if(request.getServletPath().equals("/login/admin") ) {
			getServletContext().getRequestDispatcher("/Staff/Admin/login.jsp").forward(request, response); 
		}else if(request.getServletPath().equals("/login/regularStaff") ) {
			getServletContext().getRequestDispatcher("/Staff/login.jsp").forward(request, response); 
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println(request.getServletPath());
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("password"));
		
		if(request.getServletPath().equals("/login/student")) {
			Student stude = new Student(request.getParameter("email"),request.getParameter("password"));
			Transactions transaction = new Transactions();
			
			
			try {
			
				if(studentDao.studentLogin(stude) != null) {	
					String registration_number = studentDao.studentLogin(stude)[0][2];
					System.out.println("this the reg no" + registration_number);
					session.setAttribute("registration_number", registration_number );
					Cookie cookie = new Cookie("registration_number",registration_number);
					cookie.setMaxAge(60*60*24*5);
					response.addCookie(cookie);
					System.out.println(transactionDao.studentTransaction(registration_number)[0][0]);
					request.setAttribute("student_data", studentDao.studentLogin(stude));
					request.setAttribute("transactions_data", transactionDao.studentTransaction(registration_number));
					request.setAttribute("total_amount", transactionDao.totalAmount(registration_number));
					
					session.setAttribute("stude", stude );
					
					getServletContext().getRequestDispatcher("/Student/studentLoginAction.jsp").forward(request, response);
				}else {
					//failed login
	//				request.setAttribute("error","invlaid credentials");
					getServletContext().getRequestDispatcher("/Student/login.jsp").forward(request, response);	
				}
				
				
		
	//			System.out.println(student.studentLogin(stude));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(request.getServletPath().equals("/login/staff")) {
			Staff staff = new Staff(request.getParameter("email"),request.getParameter("password"));
			String email = request.getParameter("email");
			session.setAttribute("staff_email", email);
			String password = request.getParameter("password");

			try {
			
				if(staffDao.staffLogin(email, password ) != null) {
													
					//String registration_number = studentDao.studentLogin(stude)[0][2];
					//System.out.println("password");
					//System.out.println(transactionDao.studentTransaction(registration_number)[0][0]);
					/*
					 * System.out.println("one**********"); String x =
					 * staffDao.staffLogin(email,password)[0][5];
					 * System.out.println(staffDao.staffLogin(email,password)[0][0]);
					 * System.out.println(staffDao.staffLogin(email,password)[0][1]);
					 * System.out.println(staffDao.staffLogin(email,password)[0][2]);
					 * System.out.println(staffDao.staffLogin(email,password)[0][3]);
					 * System.out.println(staffDao.staffLogin(email,password)[0][4]);
					 * System.out.println(staffDao.staffLogin(email,password)[0][5]);
					 */
//					System.out.println("one**********");
					session.setAttribute("staff_email", email);
					System.out.println(staffDao.staffLogin(email,password)[0][6]);
					request.setAttribute("staff_data", staffDao.staffLogin(email,password));
//					System.out.println("**********");
					session.setAttribute("staffEmail",staff.getEmail());
					if(staffDao.staffLogin(email,password)[0][6].equals("1")) {
						getServletContext().getRequestDispatcher("/Admin/Home.jsp").forward(request, response);
					}else {
						getServletContext().getRequestDispatcher("/Staff/Home.jsp").forward(request, response);
					}
					
					
					
//					getServletContext().getRequestDispatcher("/Staff/Home.jsp").forward(request, response);
				}else {
					//failed login
	//				request.setAttribute("error","invlaid credentials");
					getServletContext().getRequestDispatcher("/Staff/login.jsp").forward(request, response);	
				}		
		
	//			System.out.println(student.studentLogin(stude));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
//		doGet(request, response);
	}

}
