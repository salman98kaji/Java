package com.blogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.entities.Student;
import com.blogs.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	//Used to create new resources. The method processes data sent in the request body and typically stores it in the database.
	@PostMapping
	public String addStudent(@RequestBody Student student) {
		Long courseId = student.getCourse().getId();
		studentService.addStudent(student, courseId);
		return "Student added succesfully";
	}	
	
	//This is used when you want to fetch data, like retrieving all students for a specific course.
	@GetMapping("/course_title/{title}")
	public List<Student> getStudentByCourseTitle(@PathVariable String title) {
		return studentService.getStudentByCourseTitle(title);	
	}
	
	//This is used when you want to delete a resource, like removing a student's admission from a course.
	//@Pathvariables,,The values of {courseId} and {studentId} in the URL are bound to the courseId and studentId method parameters.
	@DeleteMapping("/course/{courseId}/student/{studentId}")
	public String deleteStudent(@PathVariable Long courseId, Long studentId) {
		studentService.deleteStudent(courseId, studentId);
		return "Student admission canceled successfully";
		
	}
	
}
