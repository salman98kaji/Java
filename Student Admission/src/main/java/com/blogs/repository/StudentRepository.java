package com.blogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findByCourseTitle(String title);
	Student findByIdAndCourseId(Long studentId, Long courseId);
}
