package com.springboot.myapplication.service;

import java.util.List;

import com.springboot.myapplication.entity.Student;

public interface StudentService 
{
  public Student addStudent(Student student);
  
  public Student getStudent(int id);
  
  public List<Student> getAllStudents();
  
  public Student updateStudent(Student student,int id);
  
  public void deleteStudent(int id);
}
