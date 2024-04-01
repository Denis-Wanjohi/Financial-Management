<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <style>
        body {
            background-color: #f4f4f4;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        #container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .button-container {
            display: flex;
            flex-direction: column;
            gap: 1.5rem;
            text-align: center;
        }

        .button {
            padding: 1.5rem 3rem;
            border: 2px solid #333;
            border-radius: 1rem;
            background-color: #fff;
            color: #333;
            text-decoration: none;
            text-transform: uppercase;
            font-weight: bold;
            font-size: 1.2rem;
            transition: all 0.3s ease;
            cursor: pointer;
        }

        .button:hover {
            background-color: #333;
            color: #fff;
        }

        @media only screen and (min-width: 600px) {
            .button-container {
                flex-direction: row;
                justify-content: center;
            }
        }
    </style>
</head>
<body>
    <div id="container">
        <div class="button-container">
            <a href="/Final/login/student" class="button">Student</a>
            <a href="/Final/login/staff" class="button">Staff</a>
        </div>
    </div>
</body>
</html>
    