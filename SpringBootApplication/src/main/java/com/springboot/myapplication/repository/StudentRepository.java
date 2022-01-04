package com.springboot.myapplication.repository;

import java.util.List;

import com.springboot.myapplication.entity.Student;

public interface StudentRepository
{
     public Student addNewStudent(Student student);
     
     public Student getStudentDetailById(int id);
     
     public List<Student> getAllStudentDetails();
     
     public Student updateStudentDetails(Student student,int id);
     
     public void deleteStudentById(int id);
}
