package com.control;

import com.info.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Admin_Login_Control", value = "/adminlogin")
public class Admin_Login_Control extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // Get the submitted username and password.
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if (username.equals("adminath") && password.equals("athadmin"))
        {
        	response.sendRedirect("admin-view.jsp");
        }
        
        else 
        {
        	// An alert to send to login page.
            String alert = "<div class=\"alert alert-danger wrap-input100\">\n" +
                    " <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
                    " Wrong username or password!\n" +
                    " </p>\n" +
                    " </div>";
            
            // Set attribute for alert tag in loginpagepage.
            request.setAttribute("alert", alert);
            
            // Resend to login page.
            request.getRequestDispatcher("front-page.jsp").forward(request, response);
        }
    }
}