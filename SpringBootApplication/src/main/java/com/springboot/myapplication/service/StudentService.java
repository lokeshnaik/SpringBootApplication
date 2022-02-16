package com.springboot.myapplication.service;

import java.util.List;

import com.springboot.myapplication.dto.StudentDto;
import com.springboot.myapplication.dto.StudentDtoWithId;

public interface StudentService 
{
  public StudentDto addStudent(StudentDto student);
  
  public StudentDtoWithId getStudent(int id);
  
  public List<StudentDtoWithId> getAllStudents();
  
  public StudentDtoWithId updateStudent(StudentDto student,int id);
  
  public void deleteStudent(int id);
}
