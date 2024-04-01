<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
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

        #container {
            max-width: 1200px;
            margin: 20px auto;
            padding: 0 20px;
        }

        #profile {
            display: flex;
            background-color: #fff;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
        }

        #profileImage {
            flex: 0 0 35%;
            background-color: #2ea44f;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        #avator {
            border-radius: 50%;
            max-width: 100%;
            height: auto;
        }

        #profileDetails {
            flex: 1;
            padding: 20px;
        }

        #profileTable {
            width: 100%;
            border-collapse: collapse;
        }

        #profileTable td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }

        #profileTable td:first-child {
            font-weight: bold;
            width: 30%;
        }

        #history {
            background-color: #fff;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
            margin-top: 20px;
        }

        #options {
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #f0f0f0;
            border-bottom: 1px solid #ddd;
            padding: 20px;
        }

        #option {
            margin: 0 10px;
            padding: 10px 20px;
            border-radius: 4px;
            text-decoration: none;
            color: #fff;
            background-color: #2ea44f;
            transition: background-color 0.2s;
        }

        #option:hover {
            background-color: #1b7a3a;
        }

        #history table {
            width: 100%;
            border-collapse: collapse;
        }

        #history table thead th {
            background-color: #f0f0f0;
            border-bottom: 2px solid #ddd;
            padding: 10px;
            text-align: left;
        }

        #history table tbody tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        #history table tbody tr:hover {
            background-color: #f0f0f0;
        }

        #history table tbody td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }

        #history table tbody td:first-child {
            font-weight: bold;
        }

    </style>
</head>
<body>
<nav class="navbar">
 
    <div class="logo">FINANCE DASHBOARD</div>
  
    <!-- <ul class="nav-links">
      <li><a href="#home">Home</a></li>
      <li><a href="#services">Services</a></li>
      <li><a href="#contact">Contact</a></li>
    </ul> -->
  </nav>
<div id="container">
    <div id="profile">
        <div id="profileImage">
            <img src="user-placeholder.png" id="avator" alt="Profile Image">
        </div>
        <div id="profileDetails">
            <table id="profileTable">
                <tbody>
                <%
                    for(String[] dataArray :  (String[][])request.getAttribute("student_data")){
                %>
                <tr>
                    <td>Name</td>
                    <td><%=dataArray[0] %> <%=dataArray[1] %></td>
                </tr>
                <tr>
                    <td>Registration Number</td>
                    <td><%=dataArray[2] %></td>
                </tr>
                <tr>
                    <td>Programme</td>
                    <td><%=dataArray[4] %></td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td><%=dataArray[5] %></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><%=dataArray[6] %></td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
    <div id="history">
        <div id="options">
            <a id="option" href="/Final/payments">Make Payments</a>
            <a id="option" href="/Final/report">Generate Report</a>
        </div>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>ACC. NO</th>
                <th>BANK</th>
                <th>Transaction No.</th>
                <th>DATE</th>
                <th>PAID</th>
                <th>REQUIRED</th>
            </tr>
            </thead>
            <tbody>
            <%
            	
                int index = 0;
                for(String[] allTransactions :  (String[][])request.getAttribute("transactions_data")){
                    index++;
            %>
            <tr>
                <td><%=index %></td>
                <%
                    int x = 0;
                    for( String transactions :  (String[])allTransactions){
                        x++;
                        if(x==1){
                            continue;
                        }
                %>
                <td><%=transactions %></td>
                <%
                    }
                %>
                <td>200.00</td>
            </tr>
            <%
                }
            %>
            <tr>
                <td colspan="5"></td>
                <td>-3000</td>
            </tr>
            <tr>
                <td colspan="5"></td>
                <td><%=request.getAttribute("total_amount") %></td>
            </tr>
            <tr>
                <td colspan="6"></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
