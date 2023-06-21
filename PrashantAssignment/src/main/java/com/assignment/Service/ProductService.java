package com.assignment.Service;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.assignment.Dao.CategoryDto;
import com.assignment.Dao.ProductDto;
import com.assignment.Dao.ProductResponse;
import com.assignment.Exception.ResourceNotFoundException;
import com.assignment.Model.Category;
import com.assignment.Model.Product;
import com.assignment.Repository.CategoryRepository;
import com.assignment.Repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private CategoryRepository categoryRepository;



	@Autowired
	private ProductRepository productRepository;

//	public ProductDto createProduct(ProductDto product) {
//
//		Product entity =toEntity(product);
//		Product save = productRepository.save(entity);
//
//		ProductDto dto=toDto(save);
//		
//		return dto;
//		
//		
//	}
	
	public ProductDto createProduct(ProductDto productDto, int catid) {
	// Fetch Category is avable or not
	Category category = this.categoryRepository.findById(catid)
			.orElseThrow(() -> new ResourceNotFoundException("This Category id not found CAtegory"));

//	ProductDto to product
	Product product = toEntity(productDto);
	product.setCategory(category);

	// Save Product into Database
	Product save = this.productRepository.save(product);

	// Product save = productRepository.save(entity);

	// Product to ProductDto
	ProductDto dto = toDto(save);

	return dto;
}

	public ProductResponse viewAll(int pageNumber,int pageSize,String sortBy,String sortDir) {
		Sort sort=null;
		if(sortDir.trim().toLowerCase().equals("asc"))
		{
			sort  = sort.by(sortBy).ascending();
			System.out.println(sort);
		}
		else
		{
			sort=Sort.by(sortBy).descending();
			System.out.println(sort);
		}
		
		Pageable pageable =PageRequest.of(pageNumber, pageSize,sort);
		Page<Product> page= this.productRepository.findAll(pageable);
		List<Product> pageProduct=page.getContent();
		List<Product> product= pageProduct.stream().filter(p ->p.isLive()).collect(Collectors.toList());
		List<ProductDto> productDto= product.stream().map(p->this.toDto(p)).collect(Collectors.toList());
		
		ProductResponse response = new ProductResponse();
		response.setContent(productDto);
		response.setPageNumber(page.getNumber());
		response.setPageSize(page.getSize());
		response.setTotalPages(page.getTotalPages());
		response.setLastPage(page.isLast());
		
		
		
		
		//List<Product> findAll = productRepository.findAll();

		return response;
	}

	public Product viewProductById(int pid) {
		Product findById = productRepository.findById(pid).orElseThrow(()->new ResourceNotFoundException(+pid+"From this id product not found")); // commented in produ reposi and then add it
		return findById;
	}

	public void deleteProduct(int pid) {
		Product byId = productRepository.findById(pid).orElseThrow(()->new ResourceNotFoundException(+pid+"From this id product not found"));
		productRepository.delete(byId);

//		productRepository.deleteById(pid);
	}

	public Product updateProduct(int pid, Product newProduct) {
		Product oldProduct = productRepository.findById(pid).orElseThrow(()->new ResourceNotFoundException(+pid+"From this id product not found"));;
		oldProduct.setProduct_Name(newProduct.getProduct_Name());
		oldProduct.setProduct_Price(newProduct.getProduct_Price());
		oldProduct.setProduct_Desc(newProduct.getProduct_Desc());
		Product save=  productRepository.save(oldProduct);
		return save;
	}

	public Product toEntity(ProductDto pDto)
	{
		Product p=new Product();
		p.setProduct_Id(pDto.getProduct_Id());
		p.setProduct_Name(pDto.getProduct_Name());
		p.setProduct_Price(pDto.getProduct_Price());
		p.setProduct_Desc(pDto.getProduct_Desc());
		return p;
	}
	
	public ProductDto toDto(Product product)
	{
		ProductDto pDto=new ProductDto();
		pDto.setProduct_Id(product.getProduct_Id());
		pDto.setProduct_Name(product.getProduct_Name());
		pDto.setProduct_Price(product.getProduct_Price());
		pDto.setProduct_Desc(product.getProduct_Desc());
		
		return pDto;
	}
}
