<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name = "viewport" content ="width = device-width, initial-scale=1">
<link rel="stylesheet" href="asset/style/style.css"></link>
<link rel="stylesheet" href="css/bootstrap.css"></link>
<style>
	body {font-family: Arial, Helvetica, sans-serif;}
			* {box-sizing: border-box;}
	
	input[type=text], select, textarea {
		width: 100%;
		padding: 12px;
		border: 1px solid #ccc; /* grey */
		border-radius: 4px;
		box-sizing: border-box;
		margin-top: 6px;
		margin-bottom: 16px;
		resize: vertical;
	}
	
	input[type=submit] {
		background-color : #af8b4c;
		color: white;
		padding: 12px 20px;
		border: none;
		border-radius: 4px;
		cursor: pointer;
	}
	
	input[type=submit] {
		background-color: #45a049;
	}
	
	input[type=submit]:hover {
  	background-color: #FFFFE0;
	}
	
	.container {
		border-radius: 5px;
		background-color: #ADD8E6; /* light blue */
		padding: 20px;
		width: 700px;
		margin-left: 150px;
	}
	
	.section{
		padding: 250px;
    	text-align: left;
		background: linear-gradient(#FFFFFF, #E6E6FA, #C3B1E1, #E0B0FF, #CF9FFF, #FFFFFF);
	}
	
	submit {
  			width: 100%;
  			margin: 5px; 
		}
	
</style>
</head>
<body>
<%@ include file = "header.html" %>

<div class="section">

	<br><br>
	<h3 align="center">Add Electronic Product</h3>

	
	<form action="./electronicadd" method="post" enctype="multipart/form-data">
		
		${alert}
		
		<div class="container">	
		
			<label for="name">Name</label>
			<input type="text" id="name" name="name">
			<br>
			<label for="cost">Cost</label>
			<input type="text" id="cost" name="cost">
			<br>
			
			<br>
			<label for="photo">Photo</label>
			<input type="file" id="photo" name="photo" accept="image/jpeg, image/png, image/jpg">
			
			<br><br><br>
			<input type="submit" value="Submit" style="height:50px; width:150px">

		</div>
	</form>
	
</div>
<%@ include file = "footer.html" %>

</body>
</html>