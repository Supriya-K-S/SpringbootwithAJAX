package com.javatpoint.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatpoint.exceptionhandling.NoSuchStudentExistsException;
import com.javatpoint.exceptionhandling.StudentAlreadyExistsException;
import com.javatpoint.model.Student;
import com.javatpoint.repository.StudentRepository;

//defining the business logic
@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	//getting all student records
	public List<Student> getAllStudent() {
		//StudentService::getAllStudent::Start (Can be used for logging)
		List<Student> students = new ArrayList<Student>();
		studentRepository.findAll().forEach(student -> students.add(student));
		//StudentService::getAllStudent::End (Can be used for logging)
		return students;
	}

	//getting a specific record
	
	/**
	 * @author Supriya
	 * @param id
	 * @return
	 */
	public Student getStudentById(int id) {
		return studentRepository.findById(id).get();
	}

	public String saveOrUpdate(Student student) {
		Student existingStudent = studentRepository.findById(student.getId()).orElse(null);
		if(existingStudent == null) {
			studentRepository.save(student);
			return "Student added successfully";
		} else {
			throw new StudentAlreadyExistsException("Student already exists");
		}
	}

	//deleting a specific record
	public void delete(int id) {
		studentRepository.deleteById(id);
	}
	
	/**
	 */
	public void deleteall() {
		studentRepository.deleteAll();
	}

	/**
	 * 
	 * @param student
	 * @return
	 */
	public String updateStudent(Student student) {
		Student existingStudent = studentRepository.findById(student.getId()).orElse(null);
		//checking if the student already exists
		if(existingStudent == null) {
			//student doesn't exists, so throw custom exception
			throw new NoSuchStudentExistsException("No such Student exists!!");
		} else {
			//Student exists, so update the student details with new value
			/*
			 * existingStudent.setAge(student.getAge());
			 * existingStudent.setEmail(student.getEmail());
			 * existingStudent.setName(student.getName());
			 */
			studentRepository.save(student);
		return "Student Record Updated Succesfully";
		}
	}
}