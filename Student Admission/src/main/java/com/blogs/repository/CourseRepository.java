package com.blogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	
}
