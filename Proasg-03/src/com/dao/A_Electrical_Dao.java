package com.dao;

import com.info.Data_Connect;
import com.info.User;
import com.info.A_Electronic;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class A_Electrical_Dao {
    
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
    private A_Electronic queryGetUser(String query) {
        A_Electronic elec = new A_Electronic();
        try 
        {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            conn = new Data_Connect().getConnection();
            psmt = conn.prepareStatement(query);
            rs = psmt.executeQuery();
            
            if (rs.next()) 
            {
                elec.setId(rs.getInt(1));
                elec.setName(rs.getString(2));
                elec.setCost(rs.getString(3));

                // Get photo from database.
                if (rs.getBlob(4) == null) 
                {
                    elec.setBasephoto(null);
                } 
                else 
                {
                    elec.setBasephoto(getBasephoto(rs.getBlob(4)));
                }

                return elec;
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

    public void addElectronicProduct(String name, String cost, InputStream photo) 
    {
        String query = "INSERT INTO productelectronic (name, cost, photo) VALUES (?, ?, ?)";
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
    
    public static A_Electronic getProductById(int id){  
    	A_Electronic e=new A_Electronic();  
          
        try{  
            Connection con=A_Electrical_Dao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from productelectronic where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setCost(rs.getString(3));
                
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
}