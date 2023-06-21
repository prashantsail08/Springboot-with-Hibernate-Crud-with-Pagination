package com.assignment.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.Dao.CategoryDto;
import com.assignment.Exception.ResourceNotFoundException;
import com.assignment.Model.Category;
import com.assignment.Model.Product;
import com.assignment.Repository.CategoryRepository;

@Service
public class CategoryService {


	
	@Autowired
	public CategoryRepository categoryRepository;

	public Category create(Category category) {
		Category save = categoryRepository.save(category);
		return save;
	}

	public Category update(int catid,Category newCategory) {
		Category oldCategory = this.categoryRepository.findById(catid)
				.orElseThrow(() -> new ResourceNotFoundException(+catid + "From this id category not found"));
		oldCategory.setTitle(newCategory.getTitle());
		Category save = this.categoryRepository.save(oldCategory);
		return save;
		
		
	}

	public void delete(int catid) {
		Category Cat = this.categoryRepository.findById(catid)
				.orElseThrow(() -> new ResourceNotFoundException(+catid + "From this id Category not found"));
		this.categoryRepository.delete(Cat);
	}

	public Category getbyId(int catid) {

		Category findById = categoryRepository.findById(catid)
				.orElseThrow(() -> new ResourceNotFoundException(+catid + "From this id Category not found"));
		return findById;
	}

	public List<Category> getAll() {
		List<Category> findAll = categoryRepository.findAll();
		return findAll;
	}
}
