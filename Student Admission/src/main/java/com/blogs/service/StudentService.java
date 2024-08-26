package com.blogs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.entities.Course;
import com.blogs.entities.Student;
import com.blogs.repository.CourseRepository;
import com.blogs.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	//add new student
	public Student addStudent(Student student, Long courseId) {
		Course course = courseRepository.findById(courseId).orElseThrow(()-> new RuntimeException("Course not found"));
		if(student.getScore() >= course.getMinScore()) {
			student.setCourse(course);
			return studentRepository.save(student);
		} else {
			throw new RuntimeException("Score to low for admission");
		}
	}
	
	//View all students , for a specific course i/p : course title
	public List<Student> getStudentByCourseTitle(String title){
		return studentRepository.findByCourseTitle(title);	
	}
	
	//Cancel Student admission i/p : course id n student id
	public void deleteStudent(Long courseId, Long studentId) {
		Student student = studentRepository.findById(studentId).orElseThrow(()-> new RuntimeException("student not found"));
		if(student.getCourse().getId().equals(courseId)) {
			studentRepository.delete(student);
		}else {
			throw new RuntimeException("Student not enrolled in this course");
		}
	}
	
}
