<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style type="text/css">
			body{
			    background-color: rgb(12, 0, 24);
			}
			main{
			    display: flex;
			    align-items: center;
			    justify-content: center;
			}
			.wrapper-login{
			    width: 40%;
			    height: 100vh;
			
			    border-radius: 3px;
			}
			.wrapper-login h2{
			    font-size: 2em;
			    color: #fff;
			    text-align: center;
			}
			.wrapper-login .input-box{
			    position: relative;
			    width: 85%;
			    height: 50px;
			    margin: 40px 0;
			}
			.input-box input{
			    width: 100%;
			    height: 100%;
			    background: transparent;
			    border: 1px solid #fff;
			    outline: none;
			    border-radius: 40px;
			    font-size: 1em;
			    color: #fff;
			    padding: 0 25px 0 45px;
			}
			.input-box label{
			    position: absolute;
			    top: 50%;
			    left: 45px;
			    transform: translateY(-50%);
			    font-size: 1em;
			    color: #fff;
			    pointer-events: none;
			    transition: .5s;
			}
			.input-box input:focus~label,
			.input-box input:valid~label{
			    font-size: .8em;
			    top: -14px;
			    left: 17px;
			}
			.input-box .icon{
			    position: absolute;
			    left: 15px;
			    top: 14px;
			    font-size: 1.2em;
			    color: #fff;
			}
			.wrapper-login .remember-forgot{
			    font-size: .9em;
			    color: #fff;
			    font-weight: 500;
			    margin: -25px 0 15px;
			    display: flex;
			    justify-content: space-between;
			}
			.remember-forgot label input{
			    margin-right: 3px;
			}
			.remember-forgot a{
			    color: #fff;
			    text-decoration: none;
			}
			.remember-forgot a:hover{
			    text-decoration: underline;
			}
			.wrapper-login .btn{
			    width: 100%;
			    height: 50px;
			    border: none;
			    outline: none;
			    border-radius: 40px;
			    box-shadow: 0 8px 10px rgba(0, 0, 0, .5);
			    cursor: pointer;
			    background-color: aqua;
			    font-size: 1em;
			    color: #fff;
			    font-weight: 500;
			}
			.wrapper-login .register-link{
			    font-size: .9em;
			    color: #fff;
			    text-align: center;
			    margin: 30px 0;
			}
			.register-link p a{
			    color: #fff;
			    text-decoration: none;
			    font-weight: 600;
			}
			.register-link p a:hover{
			    text-decoration: underline;
			}
    </style>
    <title>Login</title>

</head>
<body>
    <main>
        <div class="wrapper-login">
            <h2>Staff Login</h2>
            <form action="/Final/login/staff" method="post">
                <div class="input-box">
                    <span class="icon"><ion-icon name = "mail"></ion-icon></span>
                    <input type= "email"  name="email" required >
                    <label>Enter your email</label>
                </div>
                <div class="input-box">
                    <span class="icon"><ion-icon name = "lock-closed"></ion-icon></span>
                    <input type= "password" name="password" required>
                    <label>Enter your password</label>
                </div>
                <div class="remember-forgot">
                    <label><input type= "checkbox">Remember me</label>
                        <a href="#">Forgot password?</a>
                </div>
                <button type="submit" class="btn">Login</button>
                <div class="register-link">
                </div>
            </form>
        </div>
    </main>
    
</body>
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script module src="https://unpkg.com/ionicons@5.5.7/dist/ionicons/ionicons.js"></script>

</html>