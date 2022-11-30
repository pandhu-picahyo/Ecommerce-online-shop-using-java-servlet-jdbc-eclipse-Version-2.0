package com.dao;

import com.info.Data_Connect;
import com.info.A_Education;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class A_Education_Dao {
    
	Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    // Get photo from database
    private String getBasephoto(Blob blob) throws SQLException, IOException {
        
    	InputStream inputStream = blob.getBinaryStream();
        ByteArrayOutputStream byteAOS = new ByteArrayOutputStream();
        
        byte[] buffer = new byte[4096];
        int bytesRead = -1;

        while ((bytesRead = inputStream.read(buffer)) != -1) 
        {
            byteAOS.write(buffer, 0, bytesRead);
        }
        
        byte[] photoBytes = byteAOS.toByteArray();

        return Base64.getEncoder().encodeToString(photoBytes);
    }

    // Get User querry
    private A_Education queryGetUser(String query) {
        A_Education edu = new A_Education();
        try 
        {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            conn = new Data_Connect().getConnection();
            psmt = conn.prepareStatement(query);
            rs = psmt.executeQuery();
            
            if (rs.next()) 
            {
                edu.setId(rs.getInt(1));
                edu.setName(rs.getString(2));
                edu.setCost(rs.getString(3));

                // Get photo from database.
                if (rs.getBlob(4) == null) 
                {
                    edu.setBasephoto(null);
                } 
                else 
                {
                    edu.setBasephoto(getBasephoto(rs.getBlob(4)));
                }

                return edu;
            }
        } 
        catch (ClassNotFoundException | SQLException | IOException e) 
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
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/asignment3", "root", "root");  
        }
        catch(Exception e)
        {System.out.println(e);}  
        	return con;  
    }  

    public void addEducationProduct(String name, String cost, InputStream photo) 
    {
        String query = "INSERT INTO producteducation (name, cost, photo) VALUES (?, ?, ?)";
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = new Data_Connect().getConnection();
            psmt = conn.prepareStatement(query);
            
            psmt.setString(1, name);
            psmt.setString(2, cost);
            psmt.setBinaryStream(3, photo);
            
            psmt.executeUpdate();
            
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            System.out.println(e.getMessage());
        }
    }  
}