package com.javatpoint.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.exceptionhandling.ErrorResponse;
import com.javatpoint.exceptionhandling.StudentAlreadyExistsException;
import com.javatpoint.model.Student;
import com.javatpoint.service.StudentService;


//creating RestController
//@CrossOrigin(origins = "http://localhost:8080/*")
@RestController
@RequestMapping("/api")
public class StudentController {
	//autowired the StudentService class
	@Autowired
	StudentService studentService;

	//creating a get mapping that retrieves all the students detail from the database 
	
	@GetMapping("/student")
	private List<Student> getAllStudent() {
		/*
		 * List<Student> obj = new ArrayList<Student>(); obj =
		 * studentService.getAllStudent(); return obj;
		 */
		return studentService.getAllStudent();
	}

	//creating a get mapping that retrieves the detail of a specific student
	@GetMapping("/student/{id}")
	private Student getStudent(@PathVariable("id") int id) {
		return studentService.getStudentById(id);
	}

	//creating a delete mapping that deletes a specific student
	@DeleteMapping("/student/{id}")
	private void deleteStudent(@PathVariable("id") int id) {
		studentService.delete(id);
	}
    
	
	//creating post mapping that post the student detail in the database
	@PostMapping("/student")
	private int saveStudent(@RequestBody Student student) {
		studentService.saveOrUpdate(student);
		return student.getId();
	}
	
	//creating delete mapping that deletes all Student entries in database
	@DeleteMapping("/student")
	private void deleteallStudent() {
		studentService.deleteall();
	}
	
	@PutMapping("/student") 
	private String updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}

	// Exception Handler method added in CustomerController to
	// handle CustomerAlreadyExistsException exception
	@ExceptionHandler(value = StudentAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ErrorResponse handleStudentAlreadyExistsException (StudentAlreadyExistsException ex) {
		return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
	}
}
