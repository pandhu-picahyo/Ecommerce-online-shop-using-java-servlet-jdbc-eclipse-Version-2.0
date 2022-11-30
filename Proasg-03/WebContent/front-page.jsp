<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <title>Project 3</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="asset/style/style.css"></link>
	<link rel="stylesheet" href="css/bootstrap.css"></link>
<style>
		body {font-family: Arial, Helvetica, sans-serif;}
			* {box-sizing: border-box;}
			
		.section{
			padding: 250px;
    		text-align: left;
			background: linear-gradient(#FFFFFF, #E6E6FA, #C3B1E1, #E0B0FF, #CF9FFF, #FFFFFF);
		}
		.styled {
    		border: 1;
    		line-height: 4.5;
    		padding: 0 20px;
    		font-size: 1rem;
    		text-align: center;
    		color: #00008B;
    		border-radius: 10px;
    		background-color: #E5E4E2;
    
		}
		
		button {
  			width: 100%;
  			margin: 5px;
  			background-color: #7DF9FF;
		}
			
</style>
</head>
<body>
<%@ include file = "header.html" %>

	 <div class="section">
		  	${alert}
		
		<div>
		<a href="admin-login-page.jsp" class="container-login100-form-btn m-t-17">
            <button type="submit" class="favorite styled">
            Admin Login
            </button></a><br><br>
         </div><div>   
        <a href="user-login-page.jsp" class="container-login100-form-btn m-t-17">
            <button type="submit" class="favorite styled">
            User Login
            </button></a><br><br>
         </div><div>   
        <a href="registration-page.jsp" class="container-login100-form-btn m-t-17">
            <button type="submit" class="favorite styled">
            New User Register
            </button></a>
		 </div>
</div>
<%@ include file = "footer.html" %>
</body>
</html>