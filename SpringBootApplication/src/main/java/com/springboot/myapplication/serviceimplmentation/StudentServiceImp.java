package com.springboot.myapplication.serviceimplmentation;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.myapplication.entity.Course;
import com.springboot.myapplication.entity.Student;
import com.springboot.myapplication.repository.StudentRepository;
import com.springboot.myapplication.service.StudentService;

@Service
@Transactional
public class StudentServiceImp implements StudentService
{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student addStudent(Student student) {

		Student student1;
		student1=studentRepository.addNewStudent(student);
		return student1;
	}

	@Override
	public Student getStudent(int id) {
		Student student=studentRepository.getStudentDetailById(id);
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> student=studentRepository.getAllStudentDetails();
		return student;
	}

	@Override
	public Student updateStudent(Student student, int id) {
		student=studentRepository.updateStudentDetails(student,id);
		return student;
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		studentRepository.deleteStudentById(id);
		return ;
	}

}
