package com.info;

public class User {
    
	private int id;
	private String firstname; 
	private String lastname;
	private String username;
	private String password;
	private String address;
	private String phone;
	private String email;

    public User() {

    }

    public User(int id, String firstname, String lastname, String username, String password, String address, String phone, String email) {
        
    	this.id = id;
    	this.firstname = firstname; 
    	this.lastname = lastname;
    	this.username = username;
    	this.password = password;
    	this.address = address;
        this.phone = phone;
        this.email = email;

    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getFirstname()
    {
    	return firstname;
    }
    
    public void setFirstname(String firstname)
    {
    	this.firstname = firstname;
    }
    
    public String getLastname()
    {
    	return lastname;
    }
    
    public void setLastname(String lastname)
    {
    	this.lastname = lastname;
    }
    
    public String getUsername() 
    {
        return username;
    }

    public void setUsername(String username) 
    {
        this.username = username;
    }
    
    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }
    
    public String getAddress() 
    {
        return address;
    }

    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getPhone() 
    {
        return phone;
    }

    public void setPhone(String phone) 
    {
        this.phone = phone;
    }
    
    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }
}