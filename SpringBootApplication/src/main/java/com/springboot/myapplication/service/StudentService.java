package com.springboot.myapplication.service;

import java.util.List;

import com.springboot.myapplication.dto.StudentDto;
import com.springboot.myapplication.entity.Student;

public interface StudentService 
{
  public StudentDto addStudent(StudentDto student);
  
  public Student getStudent(int id);
  
  public List<Student> getAllStudents();
  
  public Student updateStudent(Student student,int id);
  
  public void deleteStudent(int id);
}
