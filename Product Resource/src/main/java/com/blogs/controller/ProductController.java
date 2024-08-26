package com.blogs.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.entities.Product;
import com.blogs.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
//	The ResponseEntity class is part of the Spring Framework and represents the whole HTTP response: 
//	status code, headers, and body. It allows you to fully control the HTTP response returned from your controller.
	@PostMapping
	public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product){
		
			Product createProduct = productService.createProduct(product);
			return ResponseEntity.status(201).body(createProduct);
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id){
		Optional<Product> product = productService.getProductById(id);
		return product.map(p->ResponseEntity.status(200).body(p))
				.orElseGet(() -> ResponseEntity.status(404).body(null));
	}

}
