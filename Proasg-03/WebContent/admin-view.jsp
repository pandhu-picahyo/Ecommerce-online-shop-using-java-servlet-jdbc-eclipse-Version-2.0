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
		
		button {
  			width: 100%;
  			height: 100px;
  			margin: 15px;
  			background-color: #50C878;
		}
		
</style>
</head>
<body>
<%@ include file = "header.html" %>

	 <div class="section">
		
		<h1>Welcome : <label for="name">Admin, Please Input your data</label><br><br>
		
		${alert}
		<br>
		<a href="admin-add-electronic.jsp" class="container-login100-form-btn m-t-17">
            <button type="submit" class="login100-form-btn">
            Electronic Product
            </button></a><br><br>
            
        <a href="admin-add-education.jsp" class="container-login100-form-btn m-t-17">
            <button type="submit" class="login100-form-btn">
            Education Product
            </button></a><br><br>
      
       
        <a href="admin-add-food.jsp" class="container-login100-form-btn m-t-17">
            <button type="submit" class="login100-form-btn">
            Food Product
            </button></a><br><br>
            
        <a href="admin-add-medical.jsp" class="container-login100-form-btn m-t-17">
            <button type="submit" class="login100-form-btn">
            Medical Product
            </button></a>
		
</div>

<%@ include file = "footer.html" %>
</body>
</html>