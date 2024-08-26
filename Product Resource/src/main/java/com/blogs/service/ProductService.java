package com.blogs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.entities.Product;
import com.blogs.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product createProduct(Product product) {
		Optional<Product> existingProduct = productRepository.findByProductCode(product.getProductCode());
		if(existingProduct.isPresent()) {
			throw new IllegalArgumentException("Product with same product code already exist");
		}
		return productRepository.save(product);	
	}
	
	public Optional<Product> getProductById(Long id){
		return productRepository.findById(id);
		
	}
	
	
	
}
