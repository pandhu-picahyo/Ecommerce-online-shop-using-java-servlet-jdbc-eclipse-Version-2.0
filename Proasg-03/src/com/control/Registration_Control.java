package com.control;

import com.dao.Register_Dao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@MultipartConfig
public class Registration_Control extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	
    Register_Dao registerDao = new Register_Dao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
    	String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
 
        // Check username is existed or not from database.
        if (registerDao.checkUsernameExists(username)) 
        {
            String alert = "<div class=\"alert alert-danger wrap-input100\">\n" +
                    " <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
                    " <h1>Username already exist!</h1>\n" +
                    " </p>\n" +
                    " </div>";
            request.setAttribute("alert", alert);
            request.getRequestDispatcher("registration-page.jsp").forward(request, response);
        }
        
        // Insert username, password to database and create account.
        else 
        {
            registerDao.createUserAccount(firstname, lastname, username, password, address, phone, email);
            String alert = "<div class=\"alert alert-success wrap-input100\">\n" +
                    " <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
                    " <h1>Your data is successfully inserted, You can login now</h1>\n" +
                    " </p>\n" +
                    " </div>";
            request.setAttribute("alert", alert);
            request.getRequestDispatcher("front-page.jsp").forward(request, response);
        }
    }
}