<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            height: 100vh;
            display: grid;
            grid-template-columns: 1.5fr 2fr;
            grid-template-rows: 1fr 3fr;
            grid-template-areas:
                "header header"
                "profile quickAccess";
        }

        header {
            grid-area: header;
            background: #1D4B92;
            color: #FFF;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        #profile {
            grid-area: profile;
            padding: 20px;
            background: #F5F5F5;
            margin: auto;
        }

        #quickAccess {
            border: #333 solid 2px;
            grid-area: quickAccess;
            padding: 20px;
            display: flex;
            flex-direction: column;
            justify-content: space-around;
            padding:3rem;
        }

        .nav-link {
            padding: 10px 20px;
            margin-bottom: 5px;
            color: #333;
            text-decoration: none;
            background: #f2f2f2;
            border-radius: 5px;
            display: block;
            text-align: left;
            width: 75%;
            margin: auto;
            
        }

        .nav-link:hover {
            background: #ddd;
            border-bottom: #1D4B92 2px dashed;
            font-weight: bolder;
            padding-left: 1rem;
         
        }
        .profile_head{
        	font-weight:bolder;
        	margin:auto;
        	
        }
        .indicators{
        	font-weight:bolder;
        }
    </style>
</head>
<body>
<header>
    Finance Dashboard
</header>
<div id="profile">
	<div class="profile_head">
		<h3>PROFILE</h3>
	</div>
   <% for(String[] data:  (String[][])request.getAttribute("staff_data")) {
   	%>
   		<p><span class="indicators">Name:</span>  <%=data[0] %></p>
   		<p><span class="indicators">Staff No:</span> <%=data[1] %></p>
   		<p><span class="indicators">Gender: </span> <%=data[3] %></p>
   		<p><span class="indicators">Name:</span>  <%=data[4] %></p>
   	
   	<%	
   	
   }%>
   
   
  
</div>
<div id="quickAccess">
    <a href="/Final/staffDetails" class="nav-link">Staff Details</a>
    <a href="/Final/studentDetails" class="nav-link">Student Details</a>
    <a href="/Final/registerStaff" class="nav-link">Register Staff</a>
    <a href="/Final/registerStudent" class="nav-link">Register Student</a>
    <a href="/Final/budget" class="nav-link">Generate Reports</a>
    
</div>
</body>
</html>