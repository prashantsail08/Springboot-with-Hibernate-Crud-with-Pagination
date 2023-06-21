package com.assignment.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.Model.Category;
import com.assignment.Model.Product;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	
}
