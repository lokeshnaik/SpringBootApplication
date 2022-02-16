package com.springboot.myapplication.serviceimplmentation;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.myapplication.dto.StudentDto;
import com.springboot.myapplication.dto.StudentDtoWithId;
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
	public StudentDto addStudent(StudentDto student) {

		Student student1=new Student();
		student1.setFirstName(student.getFirstName());
		student1.setAge(student.getAge());
		student1.setContactNumber(student.getContactNumber());
		student1.setLastName(student.getLastName());
	//	student1.setStudentid(student.getStudentid());
		studentRepository.addNewStudent(student1);
		return student;
	}

	@Override
	public StudentDtoWithId getStudent(int id) {
		StudentDtoWithId stud=new StudentDtoWithId();
		Student student=studentRepository.getStudentDetailById(id);
		stud.setAge(student.getAge());
		stud.setContactNumber(student.getContactNumber());
		stud.setFirstName(student.getFirstName());
		stud.setLastName(student.getLastName());
		stud.setStudentid(student.getStudentid());
		return stud;
	}

	@Override
	public List<StudentDtoWithId> getAllStudents() {
		List<StudentDtoWithId>stud=new ArrayList<>();
		List<Student> student=studentRepository.getAllStudentDetails();
		
		for(Student stu:student)
		{
			StudentDtoWithId studo=new StudentDtoWithId();
			studo.setAge(stu.getAge());
			studo.setContactNumber(stu.getContactNumber());
			studo.setFirstName(stu.getFirstName());
			studo.setLastName(stu.getLastName());
			studo.setStudentid(stu.getStudentid());
			stud.add(studo);
		}
		return stud;
	}

	@Override
	public StudentDtoWithId updateStudent(StudentDto student, int id) {
		StudentDtoWithId stud=new StudentDtoWithId();
		Student student1=new Student();
		Student student2=new Student();
		student1.setAge(student.getAge());
		student1.setContactNumber(student.getContactNumber());
		student1.setFirstName(student.getFirstName());
		student1.setLastName(student.getLastName());
		student1.setStudentid(id);
		student2=studentRepository.updateStudentDetails(student1,id);
		stud.setAge(student2.getAge());
		stud.setContactNumber(student2.getContactNumber());
		stud.setFirstName(student2.getFirstName());
		stud.setLastName(student2.getLastName());
		stud.setStudentid(id);
	
		return stud;
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		studentRepository.deleteStudentById(id);
		return ;
	}

}
