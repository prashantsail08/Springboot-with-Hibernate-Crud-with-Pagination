package com.assignment.Dao;



import java.util.Set;

import com.assignment.Model.Category;
import com.assignment.Model.Product;

public class CategoryDto {
	private int category_Id;
	private String title;

//	private Set<Product> product;
//	
//	private Category category;

	public CategoryDto(int category_Id, String title) {
		super();
		this.category_Id = category_Id;
		this.title = title;
//		this.product = product;
//		this.category = category;
	}

	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCategory_Id() {
		return category_Id;
	}

	public void setCategory_Id(int category_Id) {
		this.category_Id = category_Id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

//	public Set<Product> getProduct() {
//		return product;
//	}
//
//	public void setProduct(Set<Product> product) {
//		this.product = product;
//	}
//
//	public Category getCategory() {
//		return category;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}

	

		
}
