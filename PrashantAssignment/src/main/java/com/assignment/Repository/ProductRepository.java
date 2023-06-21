package com.assignment.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.Model.Category;
import com.assignment.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

//	public Product findById(int product);
	
	public List<Product> findByCategory(Category category);
}
