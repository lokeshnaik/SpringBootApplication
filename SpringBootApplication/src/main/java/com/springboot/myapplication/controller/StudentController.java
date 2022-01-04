package com.springboot.myapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.myapplication.entity.Student;
import com.springboot.myapplication.service.StudentService;

@RestController
@RequestMapping("/education/student")
public class StudentController
{
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/addstudent")
	private Student addStudent(@RequestBody Student student)
	{
		Student student1=studentService.addStudent(student);
		return student1;
	}
	
	@GetMapping("/getstudent/{id}")
	private Student getStudent(@PathVariable int id)
	{
		Student student=studentService.getStudent(id);
		return student;
	}
	
	@GetMapping("/getallstudents")
	private List<Student> getAllStudents()
	{
		List<Student> students=studentService.getAllStudents();
		return students;
	}
	
	
	@PutMapping("/updatestudent/{id}")
	private Student updateStudent(@RequestBody Student student,@PathVariable int id) throws Exception
	{
	  Student student1=studentService.getStudent(id);
		
		if(student1==null)
		{
			System.out.println("Student with the given id "+id+" is not avaibale");
			throw new Exception("Student with give id "+id+" is not avaibale to update" );
		}
		
		student=studentService.updateStudent(student, id);
		return student;
	}
	
	@DeleteMapping("/deletestudent/{id}")
	private String deleteStudent(@PathVariable int id) throws Exception
	{
		Student student=studentService.getStudent(id);
		if(student==null)
		{
			throw new Exception("Student with given id "+id+" is not available to delete");
		}
		String message="Student with give id "+id +" is deleted"; 
		studentService.deleteStudent(id);
		return message;
	}
	

}
