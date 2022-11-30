package com.info;

public class A_Education {
    
	private int id;
	private String name; 
	private String cost;
    
	private byte[] photo;
    private String basephoto;
    
    public A_Education() {

    }

    public A_Education(int id, String name, String cost, String basephoto) {
        
    	this.id = id;
    	this.name = name; 
    	this.cost = cost;
        this.basephoto = basephoto;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getName()
    {
    	return name;
    }
    
    public void setName(String name)
    {
    	this.name = name;
    }
    
    public String getCost()
    {
    	return cost;
    }
    
    public void setCost(String cost)
    {
    	this.cost = cost;
    }
    
    public byte[] getPhoto() 
    {
        return photo;
    }

    public void setPhoto(byte[] photo) 
    {
        this.photo = photo;
    }

    public String getBasephoto() 
    {
        return basephoto;
    }

    public void setBasephoto(String basephoto) 
    {
        this.basephoto = basephoto;
    }
    
}