package com.control;

import java.io.IOException;
import java.io.InputStream;
import com.dao.A_Education_Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class Product_Education_Control extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	
    A_Education_Dao EducDao = new A_Education_Dao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	String name = request.getParameter("name");
        String cost = request.getParameter("cost");
 
        Part part = request.getPart("photo");
        InputStream photo = part.getInputStream();

        // Insert database.
       
            EducDao.addEducationProduct(name, cost, photo);
            String alert = "<div class=\"alert alert-success wrap-input100\">\n" +
                    " <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
                    " <h1>Your data is successfully inserted</h1>\n" +
                    " </p>\n" +
                    " </div>";
            request.setAttribute("alert", alert);
            request.getRequestDispatcher("admin-view.jsp").forward(request, response);
       
    }
}