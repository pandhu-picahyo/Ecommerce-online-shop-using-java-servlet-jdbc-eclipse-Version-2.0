package com.display;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

public class Order_Food_Product extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
	           throws ServletException, IOException {
	      response.setContentType("text/html;charset=UTF-8");
	      PrintWriter out = response.getWriter();
	 
	      Connection conn = null;
	      Statement  stmt = null;
	      ResultSet  rset = null;
	      String     sqlStr = null;
	      
	   try {
		   
		   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment3", "root", "root");
           stmt = conn.createStatement();
           
           String[] ids = request.getParameterValues("id");
           
           out.println("<br />");
           out.println("<table border='1' cellpadding='6'>");
           out.println("<tr><th>Id</th><th>Product Name</th><th>Order Date</th><th>Order Time</th><th>Cost</th></tr>");

           float totalCost = 0f;
           for (String id : ids) {
              sqlStr = "SELECT id, name, cost FROM productfood WHERE id = " + id;
              
              rset = stmt.executeQuery(sqlStr);

             
              rset.next();
              
              String name = rset.getString("name");
              String cost = rset.getString("cost");

              out.println("<tr>");
              out.println("<td>" + id + "</td>");
              out.println("<td>" + name + "</td>");
              out.println("<td>" + id + "</td>");
              out.println("<td>" + id + "</td>");
              out.println("<td>" + cost + "</td>");
              
              Integer numb = Integer.valueOf(cost);
              totalCost += numb;
           }

           out.println("<tr><td colspan='4' align='right'>Total Price: $");
           out.printf("%.2f</td></tr>", totalCost);
           out.println("</table>");

           out.println("<h3>Thank you.</h3>");
     
           out.println("</body></html>");
           
	   	} catch (SQLException ex) {
	   		out.println("<h3>Service not available. Please try again later!</h3></body></html>");
        
	   	} finally {
	   		out.close();
	   		try {
	   			if (stmt != null) stmt.close();
	   			if (conn != null) conn.close();
	   		} catch (SQLException ex) {
           
        }
     }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
     doGet(request, response);
  }
}