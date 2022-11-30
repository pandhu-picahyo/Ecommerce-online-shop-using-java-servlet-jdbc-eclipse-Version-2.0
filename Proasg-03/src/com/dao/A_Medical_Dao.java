package com.dao;

import com.info.Data_Connect;
import com.info.A_Medical;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class A_Medical_Dao {
    
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
    private A_Medical queryGetUser(String query) {
        A_Medical medic = new A_Medical();
        try 
        {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            conn = new Data_Connect().getConnection();
            psmt = conn.prepareStatement(query);
            rs = psmt.executeQuery();
            
            if (rs.next()) 
            {
                medic.setId(rs.getInt(1));
                medic.setName(rs.getString(2));
                medic.setCost(rs.getString(3));

                // Get photo from database.
                if (rs.getBlob(4) == null) 
                {
                    medic.setBasephoto(null);
                } 
                else 
                {
                    medic.setBasephoto(getBasephoto(rs.getBlob(4)));
                }

                return medic;
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

    public void addMedicalProduct(String name, String cost, InputStream photo) 
    {
        String query = "INSERT INTO productmedical (name, cost, photo) VALUES (?, ?, ?)";
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