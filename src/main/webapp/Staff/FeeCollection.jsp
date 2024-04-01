<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <style>
      body {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100vh;
        background-color: #e6f2ff;
        margin: 0;
      }
      Edit Full Screen Copy code form {
        display: grid;
        grid-template-columns: 1fr;
        grid-gap: 10px;
        background-color: white;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        width: 300px;
      }

      input {
        padding: 10px;
        border-radius: 5px;
        border: 1px solid #ccc;
        width: 100%;
        box-sizing: border-box;
      }

      input[type="submit"] {
        grid-column: span 2;
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        margin-top: 5px;
      }

      select {
        padding: 10px;
        border-radius: 5px;
        border: 1px solid #ccc;
        width: 100%;
        box-sizing: border-box;
      }

      label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
        font-size: 14px;
        text-align: center;
      }

      .full-width {
        grid-column: span 2;
      }
      .green-button {
  		display: inline-block;
  		background-color: #4CAF50; /* Green */
  		border: none;
  		color: white;
  		padding: 15px 32px;
  		text-align: center;
  		text-decoration: none;
  		display: inline-block;
  		font-size: 16px;
  		margin: 4px 2px;
  		cursor: pointer;
  		border-radius: 8px;
  		box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
		}


		.green-button:hover {
  		background-color: #45a049; 
		}
    </style>
  </head>
  <body>
    <h1 style="margin-bottom: 30px">FEE COLLECTION</h1>
    <form action="/Final/feeCollection" method="post">
      <label for="registration_number">Registration Number</label>
      <input type="text" id="registration_number" name="registration_number" />

      <label for="bank">Bank</label>
       <select id="bank" name="bank">
        	<option value="Kenya Commercial Bank Ltd">Kenya Commercial Bank Ltd</option>
        	<option value="Co-operative Bank of Kenya Ltd">Co-operative Bank of Kenya Ltd</option>
        	<option value="Standard Chartered Bank (K) Ltd">Standard Chartered Bank (K) Ltd</option>
      	</select>

      <label for="transaction_code" class="full-width">Transaction Code</label>
      <input type="text" id="transaction_code" name="transaction_code" />
      
      <input type="submit" value="Submit"/>
    </form>
    
    <%if(request.getAttribute("error") != null){
    	%>
    	<p><%=request.getAttribute("error") %></p>
    	<%
    } %>
    
    <%if(request.getAttribute("transaction_details") != null){
    	
    	%>
    	<table border="1">
		  <thead>
		    <tr>
		    
		      <th>Account No</th>
		      <th>Registration Number</th>
		      <th>Bank</th>
		      <th>Transaction ID</th>
		      <th>Date</th>
		      <th>Amount</th>
		      
		  
		      
		     
		    </tr>
		  </thead>
		  <tbody>
		    <% for (String[] data : (String[][])request.getAttribute("transaction_details") ) { %>
		      <tr>
		        <td><%= data[0] %></td>
		        <td><%= data[1] %></td>
		        <td><%= data[2] %></td>
		        <td><%= data[3] %></td>
		        <td><%= data[4] %></td>
		        <td><%= data[5] %></td>
		       
		      </tr>
		    <% } %>
		  </tbody>
		</table>
    	<button class="green-button">ALLOW GATEPASS</button>
    	
    	
    	<%
    	
    } %>
    
  </body>
</html>
