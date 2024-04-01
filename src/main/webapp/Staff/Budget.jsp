<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <style>
      * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
      }
      body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
      }
          a {
      text-decoration: none;
    }

    li {
      list-style: none;
    }

    /* NAVBAR STYLING STARTS */
    .navbar {
      display: flex;
      align-items: center;
      justify-content: space-between;
      padding: 20px;
      background-color: teal;
      color: #fff;
    }

    .nav-links a {
      color: #fff;
    }

    /* LOGO */
    .logo {
      font-size: 32px;
    }

    /* NAVBAR MENU */
    .nav-links {
      display: flex;
      gap: 1em;
      font-size: 18px;
    }

    .nav-links li:hover {
      background-color: #4c9e9e;
      border-radius: 5px;
      transition: 0.3s ease;
    }

    .nav-links li {
      padding: 5px 14px;
    }
      .container {
        width: 100%;
        max-width: 1200px;
        margin: 0 auto;
        padding: 2rem;
      }
      .dashboard {
        display: grid;
        grid-template-columns: repeat(4, 1fr);
        grid-gap: 2rem;
      }
      .card {
        background-color: #fff;
        border-radius: 5px;
        padding: 2rem;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
      }
      .card h3 {
        font-size: 1.5rem;
        margin-bottom: 1rem;
      }
      .card p {
        font-size: 1rem;
        color: #666;
        margin-bottom: 1rem;
      }
      .card span {
        font-size: 1.2rem;
        font-weight: bold;
      }
      .confirmation_button{
      	padding: 10px 20px; 
      	border-radius: 5px; 
      	color: white; 
      	background-color: blue; 
      	border: none; 
      	cursor: pointer;
      }
      
        header {
            padding: 1rem 2rem;
            display: flex;
            justify-content: center;
            align-items: center;
            color: #333;
                   
        }

        header h1 {
            margin: 0;
        }

        main {
            padding: 1rem 2rem;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            table-layout: fixed;
        }

        th, td {
            padding: 0.5rem;
            border: 1px solid #ddd;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }

        th {
            font-weight: bold;
            background-color: #444;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }

        footer {
            padding: 1rem 2rem;
            background-color: #333;
            color: white;
            display: flex;
            justify-content: center;
        }

        footer p {
            margin: 0;
        }

        .container1 {
            max-width: 900px;
            margin: 0 auto;
            overflow: auto;
        }
      @media (max-width: 960px) {
        .dashboard {
          grid-template-columns: repeat(2, 1fr);
        }
      }
      @media (max-width: 640px) {
        .dashboard {
          grid-template-columns: 1fr;
        }
      }
    </style>
    <title>Finance Allocation Dashboard</title>
  </head>
  <body>
	  <nav class="navbar">
	    <!-- LOGO -->
	    <div class="logo">MUO</div>
	    <!-- NAVIGATION MENU -->
	    <ul class="nav-links">
	      <li><a href="#home">Home</a></li>
	      <li><a href="/Final/budget">Reports</a></li>
	      <li><a href="/Final/registerStudent">Register Student</a></li>
	       <li><a href="/Final/registerStaff">Register Staff</a></li>
	        <li><a href="/Final/staffDetails">Staff Details</a></li>
	         <li><a href="/Final/studentDetails">Student Details</a></li>
	    </ul>
	  </nav>
    <div class="container">
      <h1>Finance Allocation Dashboard</h1>
      <div class="dashboard">
         <%for(String[] budget: (String[][])request.getAttribute("budget")) {%>
        <div class="card">
          <h3>Mess</h3>
          <p>This month's expenses:</p>
          <span>Ksh <%=budget[0] %></span>
        </div>
        <div class="card">
          <h3>Library</h3>
          <p>This month's expenses:</p>
          <span>Ksh <%=budget[1] %></span>
        </div>
        <div class="card">
          <h3>Salaries</h3>
          <p>This month's expenses:</p>
          <span>Ksh <%=budget[2] %></span>
        </div>
        <div class="card">
          <h3>Maintenance</h3>
          <p>This month's expenses:</p>
          <span>Ksh <%=budget[3] %></span>
        </div>
        <div class="card">
          <h3>Games</h3>
          <p>This month's expenses:</p>
          <span>Ksh <%=budget[4] %></span>
        </div>
        <div class="card">
          <h3>Tuition</h3>
          <p>This month's expenses:</p>
          <span>Ksh <%=budget[5] %></span>
        </div>
        <div class="card">
          <h3>Farming</h3>
          <p>This month's expenses:</p>
          <span>Ksh <%=budget[6] %></span>
        </div>
        <div class="card">
          <h3>Miscellaneous</h3>
          <p>This month's expenses:</p>
          <span>Ksh <%=budget[7] %></span>
        </div>
        <%} %>
      </div>
      <div style="margin-right: auto;backgroud-green:blue; display: flex; justify-content: space-between; gap: 10px; margin-top:10px;">
    		<a  href="/Final/expenseManagement">
    			<button class="confirmation_button">BACK</button>
    		</a>
    		<form action="/Final/Home" method="post">
    			<input value=<%=session.getAttribute("staff_detail") %> name="email" style="visibility:hidden;"/>
    			<button class="confirmation_button">DONE</button>
    		</form>
    		
    		
  		</div>
  		
    </div>
		
	<header>
	    <h1>Payroll Summary</h1>
	</header>
	
	<main>
	    <div class="container1">
	        <table>
	            <thead>
	                <tr>
	                    <th>Group</th>
	                    <th>Number of Workers</th>
	                    <th>Date</th>
	                    <th>Amount per Worker</th>
	                    <th>Total Pay</th>
	                </tr>
	            </thead>
	            <tbody>
	            	<%for(String[] dataArray : (String[][])request.getAttribute("payroll")){ %>
	                <tr>
	                	<%for(String data : (String[])dataArray) {%>
	                    <td><%=data %></td>
	                   <!--  <td>10</td>
	                    <td>March 2024</td>
	                    <td>$2000</td>
	                    <td>$20,000</td> -->
	                    <%} %>
	                </tr>
	                <%} %>
	            </tbody>
	        </table>
	    </div>
	</main>
	
	<!-- <footer>
	    <p>&copy; 2023 Payroll Management System</p>
	</footer> -->

  </body>
</html>