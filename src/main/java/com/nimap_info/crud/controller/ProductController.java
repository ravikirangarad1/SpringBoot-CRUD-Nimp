package com.nimap_info.crud.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.nimap_info.crud.entity.Product;
import com.nimap_info.crud.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	// 1. Get all products with pagination
	@GetMapping
	public Page<Product> getAllProducts(@RequestParam(defaultValue = "2") int page,
			@RequestParam(defaultValue = "10") int size) {
		return productService.getAllProducts(PageRequest.of(page, size));
	}

	// 2. Get product by Id (with category details)
	@GetMapping("/{id}")
	public Optional<Product> getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}

	// 3. Create a new product
	@PostMapping
	public Product createProduct(@RequestBody Product product) {

		return productService.createProduct(product);

	}

	// 4. Update product by Id
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
		return productService.updateProduct(id, productDetails);
	}

	// 5. Delete product by Id
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}

}
