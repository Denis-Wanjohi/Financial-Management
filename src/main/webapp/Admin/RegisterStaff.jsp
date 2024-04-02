<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Registration Form</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        margin:0;
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
      form {
        width: 300px;
        margin: 50px auto;
        padding: 1rem;
        background-color: #fff;
        border: 1px solid #ddd;
        border-radius: 5px;
      }
      label {
        display: block;
        margin-bottom: 0.5rem;
        text-align: left;
        font-size: 1.1rem;
      }
      input[type="text"],
      input[type="email"],
      input[type="password"] select {
        width: 100%;
        padding: 0.75rem;
        border-radius: 0.25rem;
        border: 1px solid #ddd;
        box-sizing: border-box;
      }
      input[type="submit"] {
        width: 100%;
        padding: 0.75rem;
        background-color: #49b53f;
        color: #fff;
        border: none;
        border-radius: 0.25rem;
        cursor: pointer;
        margin-top: 1rem;
      }
      select {
        appearance: none;
        padding: 0.75rem;
        border-radius: 0.25rem;
        border: 1px solid #ccc;
      }
      span {
        font-size: 0.8rem;
        color: #888;
      }
    </style>
  </head>
  <body>
 <nav class="navbar">
 
    <div class="logo">FINANCE</div>
  
    <ul class="nav-links">
       <li><a href="#home">Home</a></li>
	      <li><a href="/Final/proposedBudget">Reports</a></li>
	      <li><a href="/Final/registerStudents">Register Student</a></li>
	      <li><a href="/Final/staffDetails">Staff Details</a></li>
	      <li><a href="/Final/studentsDetails">Student Details</a></li>
    </ul>
  </nav>
    <form>
      <label for="name">Name:</label>
      <input type="text" id="name" name="name" required />
      <span>*</span>

      <label for="email">Email:</label>
      <input type="email" id="email" name="email" required />
      <span>*</span>

      <label for="staff_number">Staff Number:</label>
      <input type="text" id="staff_number" name="staff_number" required />
      <span>*</span>

      <label for="identification_number">Identification Number:</label>
      <input
        type="text"
        id="identification_number"
        name="identification_number"
        required
      />
      <span>*</span>

      <label for="phone_number">Phone Number:</label>
      <input type="text" id="phone_number" name="phone_number" required />
      <span>*</span>

      <label for="password">Password:</label>
      <input type="password" id="password" name="password" required />
      <span>*</span>

      <div style="display: flex; justify-content: space-around">
        <div>
          <label for="gender">Gender:</label>
          <select id="gender" name="gender" required>
            <option value="" disabled selected hidden>Select gender</option>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
          </select>
          <span>*</span>
        </div>
        <div>
          <label for="gender">Type:</label>
          <select id="gender" name="gender" required>
            <option value="" disabled selected hidden>Select type</option>
            <option value="Male">Staff</option>
            <option value="Female">Admin</option>
          </select>
          <span>*</span>
        </div>
      </div>

      <input type="submit" value="Register" />
    </form>
  </body>
</html>
    