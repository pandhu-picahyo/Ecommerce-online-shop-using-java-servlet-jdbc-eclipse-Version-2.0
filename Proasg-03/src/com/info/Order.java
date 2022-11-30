package com.info;

import java.io.InputStream;
import java.sql.Date;

import javax.servlet.http.Part;

public class Order 
{
	
	private int id;
	private String productname;
	Date date, time;

	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getProductname() 
	{
		return productname;
	}
	
	public void setProductname(String productname) 
	{
		this.productname = productname;
	}
	
	public Date getDate() 
	{
		return date;
	}
	
	public void setDate(Date date) 
	{
		this.date = date;
	}
	
	public Date getTime() 
	{
		return time;
	}
	
	public void setTime(Date time) 
	{
		this.time = time;
	}
}