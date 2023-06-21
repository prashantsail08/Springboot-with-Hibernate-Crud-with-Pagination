package com.assignment.Model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int category_Id;
	private String title;
	
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Product> product;
	//why we use set<product> becz new will be getting many data in product.
	
	
	
	public Set<Product> getProduct(Set<Product> product) {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int category_Id, String title) {
		super();
		this.category_Id = category_Id;
		this.title = title;
	}
	
	

	public Category(int category_Id, String title, Set<Product> product) {
		super();
		this.category_Id = category_Id;
		this.title = title;
		this.product = product;
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
	
	
	
}
