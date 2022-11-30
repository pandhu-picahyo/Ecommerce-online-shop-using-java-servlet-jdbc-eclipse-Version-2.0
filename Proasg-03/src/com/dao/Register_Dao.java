package com.dao;

import com.info.Data_Connect;
import com.info.User;
import java.sql.*;


public class Register_Dao {
    
	Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;
    
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
    // Check username is exist?
    public boolean checkUsernameExists(String username) 
    {
        String query = "SELECT * FROM userregister WHERE username = '" + username + "'";
        return (queryGetUser(query) != null);
    }

    // Create an user account.
    public void createUserAccount(String firstname, String lastname, String username, String password, String address, String phone, String email) 
    {
        String query = "INSERT INTO userregister (firstname, lastname, username, password, address, phone, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = new Data_Connect().getConnection();
            psmt = conn.prepareStatement(query);
            
            psmt.setString(1, firstname);
            psmt.setString(2, lastname);
            psmt.setString(3, username);
            psmt.setString(4, password);
            psmt.setString(5, address);
            psmt.setString(6, phone);
            psmt.setString(7, email);
            
            psmt.executeUpdate();
            
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }
  
}