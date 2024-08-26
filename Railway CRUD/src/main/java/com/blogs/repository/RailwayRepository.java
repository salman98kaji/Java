package com.blogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogs.entities.Category;
import com.blogs.entities.Railway;

@Repository
//This interface provides various methods to interact with the database, such as saving, deleting, and finding entities.
//By extending JpaRepository, the RailwayRepository inherits several methods for working with Railway persistence, including methods like save, findAll, findById, deleteById, etc.
public interface RailwayRepository extends JpaRepository<Railway, Long> {
	
	List<Railway> findByCategory(Category category);
}

//List<Railway>: This indicates that the method will return a list of Railway entities.
//findByCategory(Category category):
//findByCategory: This is a custom query method. The name follows a specific convention that Spring Data JPA understands and translates into a query. Specifically, findBy indicates a search operation, and Category specifies the field in the Railway entity to search by.
//Category category: This is the method parameter. It specifies that the method will take a Category enum value as an argument and will return all Railway entities that have this category.
