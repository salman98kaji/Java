package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.entities.Course;
import com.blogs.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping
	public String addCourse(@RequestBody Course course) {
		courseService.addCourse(course);
		return "Course added successfully";
	}
	
	//Used to update existing resources. The method processes data from the URL path and request body to modify existing records in the database.
	@PutMapping("/{courseId}/fees/{fees}")
	public String updateCourseFees(@PathVariable Long courseId, @PathVariable Double fees) {
		courseService.updateCourseFees(courseId, fees);
		return "COurse fees updated succesfully";
	}
}
