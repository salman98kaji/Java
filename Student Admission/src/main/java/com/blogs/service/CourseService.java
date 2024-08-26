package com.blogs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.entities.Course;
import com.blogs.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	//add new course
	public Course addCourse(Course course) {
		return courseRepository.save(course);	
	}
	
	//update course fees
	public Course updateCourseFees(Long courseId, Double fees) {
		Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
		course.setFees(fees);
		return courseRepository.save(course);
	}
	
	
	
}
