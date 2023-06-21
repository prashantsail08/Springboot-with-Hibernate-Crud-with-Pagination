package com.assignment.Controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.Dao.AppConstants;
import com.assignment.Dao.ProductDto;
import com.assignment.Dao.ProductResponse;
import com.assignment.Model.Product;
import com.assignment.Service.ProductService;

@RestController
@RequestMapping("/c")
public class ProductController {



	@Autowired
	private ProductService productService;


	
	@PostMapping("/create/{catid}")
	@ResponseBody
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto product, @PathVariable int catid) {
		System.out.println(product.getProduct_Name());
		ProductDto createProduct = productService.createProduct(product,catid);

		return new ResponseEntity<ProductDto>(createProduct,HttpStatus.CREATED);
	}

	// this is for view Product
	@GetMapping("/view")
	public ProductResponse viewAllProduct(@RequestParam(value="pageNumber",defaultValue =AppConstants.PAGE_NUMBER_STRING,required = false) int pageNumber,
	        @RequestParam(value="pageSize",defaultValue = AppConstants.PAGE_SIZE_STRING,required = false) int pageSize,
            @RequestParam(value="sortBy",defaultValue = AppConstants.SORT_BY_STRING,required = false) String sortBy,
            @RequestParam(value="sortDir",defaultValue = AppConstants.SORT_DIR_STRING,required=false) String sortDir)
	{
		ProductResponse response = productService.viewAll(pageNumber,pageSize,sortBy,sortDir);
		return response;
	}

//	this if for view product by id
	@GetMapping("/view/{productId}")
	public Product viewProductById(@PathVariable int productId) {
		Product viewById = productService.viewProductById(productId);
		return viewById;
	}

	// delete product
	@DeleteMapping("/del/{productId}")
	public void deleteProduct(@PathVariable int productId) {
		productService.deleteProduct(productId);
	}

	// update product
	@PutMapping("/update/{productId}")
	public Product updateProduct(@PathVariable int productId, @RequestBody Product newProduct) {
		Product updateProduct = productService.updateProduct(productId,newProduct);
		return updateProduct;
	}
}
