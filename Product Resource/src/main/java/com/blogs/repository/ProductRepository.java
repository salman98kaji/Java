package com.blogs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
	Optional<Product> findByProductCode(String productCode);
}
