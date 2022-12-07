<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.info.A_Medical"%>
<%@page import="com.dao.A_Medical_Dao"%>
<%
	String id = request.getParameter("id");
	String driver = "com.mysql.cj.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/";
	String database = "assignment3";
	String userid = "root";
	String password = "root";
try {
	Class.forName(driver);
	} catch (ClassNotFoundException e) {
	e.printStackTrace();
	}
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<head>
<title>Project 3</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="asset/style/style.css"></link>
	<link rel="stylesheet" href="css/bootstrap.css"></link>
<style>
		
		.grid-container {
  			display: grid;
  			gap: 50px 50px;
  			grid-template-columns: auto auto auto;
  			background-color: #2196F3;
  			padding: 10px;
		}
		.grid-item {
  			background-color: rgba(255, 255, 255, 0.8);
  			border: 1px solid rgba(0, 0, 0, 0.8);
  			padding: 20px;
  			font-size: 30px;
  			text-align: center;
		}
</style>
</head>
<body>

<%@ include file = "header.html" %>

	<form method="get" action="./medicalorder">
	<h1>Food Product</h1>
	
	<div class="grid-container">
	<%
		try{
			connection = DriverManager.getConnection(connectionUrl+database, userid, password);
			statement=connection.createStatement();
			String sql ="select * from productmedical";
			resultSet = statement.executeQuery(sql);

		while(resultSet.next()){
	%>
	<div class="grid-item">
		<img src="Image_Medical?id=<%=resultSet.getInt("id") %>" width= "50px" />
		<h6><%=resultSet.getString("name") %></h6>
		<h6>$ <%=resultSet.getString("cost") %></h6>
		<input type="checkbox" name="id" value="<%=resultSet.getInt("id") %>"/>
	</div>
	<%
		}
			connection.close();
		} catch (Exception e) {	
			e.printStackTrace();
		}
	%>
	
	</div>
		<input type="submit" value="order" />
	</form>	

<%@ include file = "footer.html" %>
</body>
</html>