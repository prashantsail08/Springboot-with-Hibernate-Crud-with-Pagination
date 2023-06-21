  package com.assignment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.Dao.CategoryDto;
import com.assignment.Exception.ApiResponse;
import com.assignment.Model.Category;
import com.assignment.Service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {


	

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/create")
	public Category create(@RequestBody Category category) {
		Category create = this.categoryService.create(category);
		return create;
	}
	
	@PutMapping("/update/{catid}")
	public Category update(@PathVariable int catid, @RequestBody Category newCategory) {
		Category update = this.categoryService.update(catid,newCategory );
		return update;
	}

	@DeleteMapping("/delete/{catid}")
	public ResponseEntity<ApiResponse> delete(@PathVariable int catid) {
		this.categoryService.delete(catid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted Successfully", true), HttpStatus.OK);
	}

	@GetMapping("getByid/{catid}")
	public Category getCategoryById(@PathVariable int catid) {
		Category getById = this.categoryService.getbyId(catid);
		return getById;
	}

	@GetMapping("getAll")
	public List<Category> getAll() {
		List<Category> all = this.categoryService.getAll();
		return all;
	}
}
