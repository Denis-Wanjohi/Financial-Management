<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <style>
      body {
        font-family: "Open Sans", sans-serif;
        background-color: #f5f5f5;
      }

      h1 {
        text-align: center;
        color: #333;
        margin-top: 50px;
        margin-bottom: 50px;
      }

      #student-table {
        width: 100%;
        border-collapse: collapse;
        background-color: #fff;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
      }

      #student-table th {
        background-color: #4caf50;
        color: #fff;
        font-weight: bold;
        padding: 10px;
        text-align: left;
      }

      #student-table td {
        padding: 10px;
        border-bottom: 1px solid #ddd;
        border: 1px solid rgb(187, 187, 202);
      }

      #student-table tbody tr:nth-child(even) {
        background-color: #f2f2f2;
        
      }

      #student-table th,
      #student-table td {
        font-size: 16px;
      }

      #student-table th:first-child,
      #student-table td:first-child {
        padding-left: 20px;
      }

      #student-table th:last-child,
      #student-table td:last-child {
        padding-right: 20px;
      }

      #student-table th:nth-child(3),
      #student-table td:nth-child(3) {
        text-align: center;
      }

      #student-table th:nth-child(4),
      #student-table td:nth-child(4) {
        text-align: center;
      }

      #student-table th:nth-child(5),
      #student-table td:nth-child(5) {
        text-align: center;
      }

      #student-table th:nth-child(10),
      #student-table td:nth-child(10) {
        text-align: right;
        padding-right: 20px;
      }

      #student-table th:nth-child(10)::before {
        content: "$";
      }

      @media screen and (max-width: 768px) {
        #student-table th,
        #student-table td {
          display: block;
          width: 100%;
          text-align: center;
          margin-bottom: 10px;
        }

        #student-table th:first-child,
        #student-table td:first-child {
          padding-left: 0;
        }

        #student-table th:last-child,
        #student-table td:last-child {
          padding-right: 0;
        }

        #student-table th:nth-child(3),
        #student-table td:nth-child(3) {
          text-align: center;
        }

        #student-table th:nth-child(4),
        #student-table td:nth-child(4) {
          text-align: center;
        }

        #student-table th:nth-child(5),
        #student-table td:nth-child(5) {
          text-align: center;
        }

        #student-table th:nth-child(10),
        #student-table td:nth-child(10) {
          text-align: right;
          padding-right: 0;
        }

        #student-table th:nth-child(10)::before {
          content: "";
        }
      }
    </style>
  </head>
  <body>
    <h1>Student Information</h1>
    <table id="student-table">
      <thead>
        <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Registration Number</th>
          <th>Identification Number</th>
          <th>Gender</th>
          <th>Email</th>
          <th>Phone Number</th>
          <th>Programme</th>
          <th>Amount</th>
        </tr>
      </thead>
      <tbody>
      	<%for (String[] dataArray : (String[][])request.getAttribute("student_details")){ %>
        <tr>
        	<%for(String data : (String[])dataArray) {%>
        	<td><%=data %></td>
          
          <%} %>
        </tr>
        <%} %>
        <!-- Add more rows here --> 
      </tbody>
    </table>
  </body>
</html>