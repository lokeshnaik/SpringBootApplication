package com.springboot.myapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.myapplication.dto.StudentDto;
import com.springboot.myapplication.dto.StudentDtoWithId;
import com.springboot.myapplication.entity.Student;
import com.springboot.myapplication.response.StudentResponse;
import com.springboot.myapplication.service.StudentService;

@RestController
@RequestMapping("/education/student")
public class StudentController
{
	@Autowired
	private StudentService studentService;

	@PostMapping("/addstudent")
	private ResponseEntity<StudentResponse> addStudent(@RequestBody StudentDto student)
	{
		StudentDto student1=studentService.addStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(new StudentResponse("Student is added",201,student1));
	}

	@GetMapping("/getstudent/{id}")
	private ResponseEntity<StudentResponse> getStudent(@PathVariable int id)
	{
		StudentDtoWithId student=studentService.getStudent(id);
		return ResponseEntity.status(HttpStatus.OK).body(new StudentResponse("Got the student of given desired id",200,student));
	}

	@GetMapping("/getallstudents")
	private ResponseEntity<StudentResponse> getAllStudents()
	{
		List<StudentDtoWithId> students=studentService.getAllStudents();
		return ResponseEntity.status(HttpStatus.OK).body(new StudentResponse("Got the student those are available in the list",200,students));
	}


	@PutMapping("/updatestudent/{id}")
	private ResponseEntity<StudentResponse> updateStudent(@RequestBody StudentDto student,@PathVariable int id) throws Exception
	{
		StudentDtoWithId student1=studentService.getStudent(id);

		if(student1==null)
		{
			System.out.println("Student with the given id "+id+" is not avaibale");
			throw new Exception("Student with give id "+id+" is not avaibale to update" );
		}
	///	StudentDtoWithId stud=new StudentDtoWithId();

		StudentDtoWithId stud=studentService.updateStudent(student, id);
		return ResponseEntity.status(HttpStatus.OK).body(new StudentResponse("Student with give id="+id+" is updated",200,stud));
	}

	@DeleteMapping("/deletestudent/{id}")
	private ResponseEntity<StudentResponse> deleteStudent(@PathVariable int id) throws Exception
	{
		StudentDtoWithId student=studentService.getStudent(id);
		if(student==null)
		{
			throw new Exception("Student with given id "+id+" is not available to delete");
		}
		String message="Student with give id "+id +" is deleted"; 
		studentService.deleteStudent(id);
		return ResponseEntity.status(HttpStatus.OK).body(new StudentResponse(message,204,null));
	}


}
