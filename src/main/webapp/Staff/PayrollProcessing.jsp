<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pay Allocation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            padding: 0 2rem;
        }
        
        form {
            width: 100%;
            max-width: 500px;
            background-color: #fff;
            padding: 2rem;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            border-radius: 4px;
        }
        
        h1 {
            text-align: center;
            margin-bottom: 2rem;
        }
        
        label {
            display: inline-block;
            margin-bottom: 0.5rem;
            width: 100%;
        }
        
        .input-group {
            margin-bottom: 1rem;
        }
        
        input[type="number"], input[type="month"], input[type="number"][name="amount"], select {
            display: block;
            width: 100%;
            padding: 0.5rem;
            margin-bottom: 1rem;
            border-radius: 4px;
            border: 1px solid #ccc;
        }
        
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 0.5rem;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
            margin-top: 1rem;
        }
        
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <form action="/Final/payroll" method="post">
            <h1>Allocate Pay for Staff</h1>
            <div class="input-group">
                <label>Group:</label>
                <select name="group" id="group" required>
                    <option value="MESS">Mess Group </option>
                    <option value="Library">Library Group</option>
                    <option value="Salaries">Salaries Group</option>
                    <option value="Maintenance">Maintenance Group</option>
                    <option value="Games">Games Group</option>
                    <option value="Tuition">Tuition Group </option>
                    <option value="Farming">Farming  Group</option>
                    <option value="Miscellaneous">Miscellaneous  Group </option>
                </select>
            </div>
            <div class="input-group">
                <label>Number of Workers:</label>
                <input type="number" name="workers" min="1" max="1000" required>
            </div>
            <div class="input-group">
                <label>Year:</label>
                <input type="date" name="period" required>
            </div>
            <div class="input-group">
                <label>Amount per Worker:</label>
                <input type="number" name="amount" min="1" max="20000" required>
            </div>
            <input type="submit" value="Allocate Pay">
        </form>
    </div>
</body>
</html>