package com.blogs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.entities.Category;
import com.blogs.entities.Railway;
import com.blogs.repository.RailwayRepository;

@Service
public class RailwayService {

	@Autowired
	private RailwayRepository railwayRepository;
	
	//add railway
	public Railway addRailway(Railway railway) {
		return railwayRepository.save(railway);
	}
	
	//delete railway
	public void deleteRailway(Long id) {
		railwayRepository.deleteById(id);
	}
	
	//get all railways by category
	public List<Railway> getAllRailByCategory(Category category){
		return railwayRepository.findByCategory(category);
	}
	
	//get railway by id
	public Optional<Railway> getRailById(Long id){
		return railwayRepository.findById(id);
	}
}
