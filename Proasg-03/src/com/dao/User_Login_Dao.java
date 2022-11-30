package com.dao;

import com.info.Data_Connect;
import com.info.User;

import java.sql.*;

public class User_Login_Dao {
    
	Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    // Get User querry
    private User queryGetUser(String query) {
        User user = new User();
        try 
        {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            conn = new Data_Connect().getConnection();
            psmt = conn.prepareStatement(query);
            rs = psmt.executeQuery();
            
            if (rs.next()) 
            {
                user.setId(rs.getInt(1));
                user.setFirstname(rs.getString(2));
                user.setLastname(rs.getString(3));
                user.setUsername(rs.getString(4));
                user.setPassword(rs.getString(5));
                user.setAddress(rs.getString(6));
                user.setPhone(rs.getString(7));
                user.setEmail(rs.getString(8));
                
                return user;
            }
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static Connection getConnection(){  
    	
        Connection con=null;  
        try
        {  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment3", "root", "root");  
        }
        catch(Exception e)
        {System.out.println(e);}  
        	return con;  
    }  

    // Check login
    public User checkLoginUser(String username, String password) 
    {
        String query = "SELECT * FROM userregister WHERE username = '" + username + "' AND password = '" + password + "'";
        return queryGetUser(query);
    }

}