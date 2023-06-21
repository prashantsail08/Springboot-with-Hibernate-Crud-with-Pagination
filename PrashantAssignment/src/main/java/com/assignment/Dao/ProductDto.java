package com.assignment.Dao;

import com.assignment.Model.Category;

public class ProductDto {

	private int product_Id;
	private String product_Name;
	private double product_Price;
	private String product_Desc;
	private boolean live;
	
	
	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProductDto(int product_Id, String product_Name, double product_Price, String product_Desc, boolean live) {
		super();
		this.product_Id = product_Id;
		this.product_Name = product_Name;
		this.product_Price = product_Price;
		this.product_Desc = product_Desc;
		this.live = live;
	}


	public int getProduct_Id() {
		return product_Id;
	}


	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}



	public String getProduct_Name() {
		return product_Name;
	}



	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}



	public double getProduct_Price() {
		return product_Price;
	}



	public void setProduct_Price(double product_Price) {
		this.product_Price = product_Price;
	}



	public String getProduct_Desc() {
		return product_Desc;
	}



	public void setProduct_Desc(String product_Desc) {
		this.product_Desc = product_Desc;
	}
	
	



	public boolean isLive() {
		return live;
	}



	public void setLive(boolean live) {
		this.live = live;
	}



	public void setCategory(CategoryDto catDto) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
