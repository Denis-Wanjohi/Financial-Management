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
      .card input[type="number"] {
        width: 100%;
        padding: 0.5rem;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 1rem;
        margin-bottom: 1rem;
      }
      .card button {
        background-color: #4CAF50;
        color: #fff;
        border: none;
        padding: 0.5rem 1rem;
        border-radius: 4px;
        cursor: pointer;
        font-size: 1rem;
        transition: background-color 0.3s;
      }
      .card button:hover {
        background-color: #3e8e41;
      }
      .money_button{
      	padding: 10px 20px; 
      	border-radius: 5px; 
      	color: white; 
      	background-color: green; 
      	border: none; 
      	cursor: pointer;
      }
      .confirmation_button{
      	padding: 10px 20px; 
      	border-radius: 5px; 
      	color: white; 
      	background-color: blue; 
      	border: none; 
      	cursor: pointer;
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
	    <div class="logo">FINANCE</div>
	  
	<ul class="nav-links">
		  <li><a href="/Final/StaffHome">Home</a></li>
	      <li><a href="/Final/registerStudent">Register Students</a></li>
		  <li><a href="/Final/feeCollection" >Fee Collection</a></li>
		  <li><a href="/Final/payrollProcessing">PayrollProcessing</a></li>
		  <li><a href="/Final/studentDetails">Student Details</a></li>
	</ul>
	</nav>
    <div class="container">
    <div style="background-color:white; display: flex; justify-content: space-between; align-items: center; gap: 10px; margin-bottom:10px;">
  		<h1 style="color: black;">Finance Allocation Dashboard</h1>
  		<div style="margin-left: auto; display: flex; gap: 10px;">
    		<button class="money_button">BALANCE: KSH <%=request.getAttribute("Total") %></button>
    		<button class="money_button">PLANNED: KSH <%=request.getAttribute("AllocatedTotal") %></button>
  		</div>
	</div>
      <div class="dashboard">
        <form action="/Final/expense" method="post">
            <div class="card">
          		<h3>Mess</h3>
          		<p>This month's expenses:</p>
          		<input type="number" name="Mess" />
          		<button>Confirm</button>
        	</div>
        </form>
        <form action="/Final/expense" method="post" >
        	<div class="card">
          		<h3>Library</h3>
          		<p>This month's expenses:</p>
          		<input type="number"  name="Library"  />
          		<button>Confirm</button>
        	</div>
        </form>
        <form action="/Final/expense" method="post" >
        	<div class="card">
          		<h3>Salaries</h3>
          		<p>This month's expenses:</p>
          		<input type="number" name="Salaries"  />
          		<button>Confirm</button>
        	</div>
        </form>
        <form action="/Final/expense" method="post" >
        	<div class="card">
          		<h3>Maintenance</h3>
          		<p>This month's expenses:</p>
          		<input type="number" name="Maintenance"  />
          		<button>Confirm</button>
        	</div>
        </form>
        <form action="/Final/expense" method="post" >
        	<div class="card">
          		<h3>Games</h3>
          		<p>This month's expenses:</p>
          		<input type="number"  name="Games"  />
          		<button>Confirm</button>
        	</div>
        </form>
        <form action="/Final/expense" method="post" >
        	<div class="card">
          		<h3>Tuition</h3>
          		<p>This month's expenses:</p>
          		<input type="number" name="Tuition"/>
          		<button>Confirm</button>
        	</div>
        </form>
        <form action="/Final/expense" method="post" >
        	<div class="card">
          		<h3>Farming</h3>
          		<p>This month's expenses:</p>
          		<input type="number" name="Farming" />
          		<input type="number" name="expense" value="0" style="visibility:hidden; width:0px; height:0px;"/>
          		<button>Confirm</button>
        	</div>
        </form>
        <form action="/Final/expense" method="post" >
        	<div class="card">
          		<h3>Miscellaneous</h3>
          		<p>This month's expenses:</p>
          		<input type="number" name="Miscellaneous"  />
          		<button>Confirm</button>
        	</div>
        </form>
        
      </div>
      <div style="margin-right: auto;backgroud-green:blue; display: flex; justify-content: space-between; gap: 10px; margin-top:10px;">
    		<a  href="/Final/budget">
    			<button class="confirmation_button">PREVIEW</button>
    		</a>
    		<form action="/Final/Home" method="post">
    			<input value=<%=session.getAttribute("staff_detail") %> name="email" style="visibility:hidden;"/>
    			<button class="confirmation_button">DONE</button>
    		</form>
  		</div>
    </div>
    
    
    
  </body>
</html>