package com.Final.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import com.Final.Dao.Budget;
import com.Final.Dao.StaffDao;
import com.Final.Dao.StudentDao;
import com.Final.Dao.TransactionDao;

/**
 * Servlet implementation class Staff
 */
@WebServlet(urlPatterns={"/Home","/registerStudent","/feeCollection","/expenseManagement","/budget","/expense","/payrollProcessing","/payroll","/studentDetails"})
public class Staff extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Student student = null ;
	StudentDao studentDao = new StudentDao();
	StaffDao  staffDao = new StaffDao();
	TransactionDao transactionDao = new TransactionDao();
	Budget budget =  new Budget();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Staff() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		if(request.getServletPath().equals("/registerStudent")) {
			getServletContext().getRequestDispatcher("/Staff/RegisterStudent.jsp").forward(request, response);
		}else if (request.getServletPath().equals("/feeCollection")) {
			getServletContext().getRequestDispatcher("/Staff/FeeCollection.jsp").forward(request, response);
		}else if(request.getServletPath().equals("/expenseManagement")) {
			try {
				request.setAttribute("AllocatedTotal", budget.getAllocatedTotal());
				request.setAttribute("Total", budget.getTotal());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getServletContext().getRequestDispatcher("/Staff/ExpenseManagement.jsp").forward(request, response);
		}else if(request.getServletPath().equals("/budget")) {
			try {
				request.setAttribute("budget", budget.budget());
				request.setAttribute("payroll", budget.payrolls());
//				request.setAttribute("", budget.payrolls());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getServletContext().getRequestDispatcher("/Staff/Budget.jsp").forward(request, response);
		}else if(request.getServletPath().equals("/payrollProcessing")) {
//			try {
//				request.setAttribute("budget", budget.budget());
//				request.setAttribute("payroll", budget.payrolls());
//			} catch (ClassNotFoundException | SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			getServletContext().getRequestDispatcher("/Staff/PayrollProcessing.jsp").forward(request, response);
		}else if(request.getServletPath().equals("/studentDetails")) {
//			request.
			try {
				request.setAttribute("student_details", studentDao.studentData());
				System.out.println(studentDao.studentData()[0][0]);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getServletContext().getRequestDispatcher("/Staff/StudentDetails.jsp").forward(request, response);
	}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
	
		if(request.getServletPath().equals("/registerStudent")) {
			
			try {
				Boolean confirmation = studentDao.registerStudent(
						request.getParameter("firtsname"),
						request.getParameter("lastname"),
						request.getParameter("registration_number"),
						request.getParameter("identification_number"),
						request.getParameter("programme"),
						request.getParameter("gender"),
						request.getParameter("email"),
						request.getParameter("password"),
						request.getParameter("phone_number")
						);
				
				if(confirmation) {
								
					request.setAttribute("staff_data", staffDao.staffByEmail( (String)session.getAttribute("staffEmail")));
					getServletContext().getRequestDispatcher("/Staff/Home.jsp").forward(request, response);
				}else {
					getServletContext().getRequestDispatcher("/Staff/RegisterStudent.jsp").forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(request.getServletPath().equals("/feeCollection")) {
			try {
				
				if(transactionDao.confirmPayment(
						request.getParameter("transaction_code"),
						request.getParameter("registration_number"),
						request.getParameter("bank")
						)  !=null) {
					request.setAttribute("transaction_details",transactionDao.confirmPayment(
							request.getParameter("transaction_code"),
							request.getParameter("registration_number"),
							request.getParameter("bank")
							));
					getServletContext().getRequestDispatcher("/Staff/FeeCollection.jsp").forward(request, response);
					
				}else {
					request.setAttribute("error", "FEE PAYMENT HASN'T BEEN DONE YET");
					getServletContext().getRequestDispatcher("/Staff/FeeCollection.jsp").forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(request.getServletPath().equals("/expense")) {
			/*
			 * try { request.setAttribute("AllocatedTotal", budget.getAllocatedTotal(1));
			 * request.setAttribute("Total", budget.getTotal()); } catch
			 * (ClassNotFoundException | SQLException e) { // TODO Auto-generated catch
			 * block e.printStackTrace(); }
			 */
			
			Enumeration<String> parameterNames = request.getParameterNames();
	        while (parameterNames.hasMoreElements()) {
	            String parameterName = parameterNames.nextElement();
	            if (parameterName.equals("Mess")) {
	                
	                try {
						Boolean confirmation = budget.updateBudget(parameterName, request.getParameter(parameterName));
						
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                break;
	            }else if (parameterName.equals("Library")) {
	               
	                try {
						Boolean confirmation = budget.updateBudget(parameterName, request.getParameter(parameterName));
						
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                break;
	            }else if (parameterName.equals("Salaries")) {
	               
	                try {
						Boolean confirmation = budget.updateBudget(parameterName, request.getParameter(parameterName));
						
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                break;
	            }else if (parameterName.equals("Maintenance")) {
	               
	                try {
						Boolean confirmation = budget.updateBudget(parameterName, request.getParameter(parameterName));
						
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                break;
	            }else if (parameterName.equals("Games")) {
	               
	                try {
						Boolean confirmation = budget.updateBudget(parameterName, request.getParameter(parameterName));
						
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                break;
	            }else if (parameterName.equals("Tuition")) {
	               
	                try {
						Boolean confirmation = budget.updateBudget(parameterName, request.getParameter(parameterName));
						
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                break;
	            }else if (parameterName.equals("Farming")) {
	               
	                try {
						Boolean confirmation = budget.updateBudget(parameterName, request.getParameter(parameterName));
						
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                break;
	            }else if (parameterName.equals("Miscellaneous")) {
	               
	                try {
						Boolean confirmation = budget.updateBudget(parameterName, request.getParameter(parameterName));
						
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                break;
	            }           
	           else {
	            	break;
	            }
	            
	        }
			
			System.out.println(request.getAttributeNames());
			try {
				request.setAttribute("AllocatedTotal", budget.getAllocatedTotal());
				request.setAttribute("Total", budget.getBalance());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			getServletContext().getRequestDispatcher("/Staff/ExpenseManagement.jsp").forward(request, response);
		}else if(request.getServletPath().equals("/Home")) {
			try {
				request.setAttribute("staff_data", staffDao.staffByEmail( (String)session.getAttribute("staffEmail")));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getServletContext().getRequestDispatcher("/Staff/Home.jsp").forward(request, response);
		}else if(request.getServletPath().equals("/payroll")) {
			
			try {
				request.setAttribute("upadate_payroll", budget.updatePayroll(
						request.getParameter("group"),
						request.getParameter("workers"),
						request.getParameter("period"),
						request.getParameter("amount")
						
						));
				getServletContext().getRequestDispatcher("/Staff/PayrollProcessing.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		doGet(request, response);
	}

}
