<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Registration</title>
    <style>
    
         body {
            font-family: Arial, sans-serif;
            margin:0px;
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
            background-color: #ddd;
            padding: 2em;
            border-radius: 10px;
            max-width: 500px;
            margin: 0 auto;
            margin-top:10px;
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 3px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="email"],
        input[type="password"],
        input[type="number"] {
            width: 100%;
            padding: 8px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        select {
            width: 100%;
            padding: 6px;
            border-radius: 5px;
            border: 1px solid #ccc;
            appearance: auto;
        }
        .half-width {
            width: 49%;
            margin-bottom: 10px;
        }
        .full-width {
            width: 100%;
            margin-bottom: 10px;
        }
        button {
            display: block;
            width: 100%;
            padding: 8px;
            border: none;
            border-radius: 5px;
            background-color: #333;
            color: #fff;
            cursor: pointer;
        }
        button:hover {
            background-color: #555;
        }
        input[type="tel"].phone-input {
            padding-left: 16px;
        }
        @media screen and (max-width: 500px) {
            .half-width {
                width: 100%;
            }
        }
    </style>
</head>
<body>
<nav class="navbar">
 
    <div class="logo">FINANCE</div>
  
    <ul class="nav-links">
       <li><a href="#home">Home</a></li>
	      <li><a href="/Final/proposedBudget">Reports</a></li>
	     
	      <li><a href="/Final/registerStaff">Register Staff</a></li>
	      <li><a href="/Final/staffDetails">Staff Details</a></li>
	      <li><a href="/Final/studentsDetails">Student Details</a></li>
    </ul>
  </nav>
<div class="container">
	
    <h1>Register Student</h1>
    <form action="/Final/registerStudent" method="post">
        <label for="first-name">First Name</label>
        <input type="text" id="first-name" name="firtsname" required>

        <label for="second-name">Second Name</label>
        <input type="text" id="second-name" name="secondname" required>
        
        <label for="programme" class="full-width">Programme</label>
        <input type="text" id="programme" class="full-width" name="programme" required>

        <label for="registration-number" class="half-width">Registration Number</label>
        <input type="text" id="registration-number" class="half-width" name="registration_number" required>

        <label for="id-number" class="half-width">Identification Number</label>
        <input type="number" id="id-number" class="half-width" name="identification_number" required>

        <label for="gender" class="half-width">Gender</label>
        <select id="gender" class="half-width"  name="gender" required>
            <option value="">Select</option>
            <option value="male">Male</option>
            <option value="female">Female</option>
           
        </select>

        <label for="email" class="full-width">Email</label>
        <input type="email" id="email" class="full-width" name="email" required>

        <label for="phone" class="full-width">Phone Number</label>
        <input type="tel" id="phone" class="full-width phone-input" name="phone" required>
        

        <label for="password" class="full-width">Password</label>
        <input type="password" id="password" class="full-width"  name="password" required>

        

        <button type="submit">Register</button>
    </form>
</div>
</body>
</html>