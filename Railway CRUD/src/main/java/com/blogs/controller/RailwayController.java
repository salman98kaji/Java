package com.blogs.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.entities.Category;
import com.blogs.entities.Railway;
import com.blogs.service.RailwayService;

@RestController
@RequestMapping("/api/railways")
@Validated
public class RailwayController {

	@Autowired
	private RailwayService railwayService;
	
	@PostMapping
	//ResponseEntity is a special type that allows us to control the HTTP status code, headers, and body of the response.
	public ResponseEntity<Railway> addRailway(@Valid @RequestBody Railway railway){
		Railway createdRailway = railwayService.addRailway(railway);
		return ResponseEntity.status(201).body(createdRailway);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Railway> deleteRailway(@PathVariable Long id){
		Optional<Railway> railway = railwayService.getRailById(id);
		if(railway.isPresent()) {
			railwayService.deleteRailway(id);
			return ResponseEntity.status(200).build();
		}else {
			return ResponseEntity.status(404).build();
		}
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Railway>> getRailwaysByCategory(@PathVariable Category category){
		List<Railway> railways = railwayService.getAllRailByCategory(category);
		if(railways.isEmpty()) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(railways);
		//.ok(railways) is the shorthand of return ReponseEntity.status(200).body(railways);
	}
	
}
