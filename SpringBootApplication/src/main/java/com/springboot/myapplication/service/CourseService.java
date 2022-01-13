package com.springboot.myapplication.service;

import java.util.List;

import com.springboot.myapplication.entity.Course;

public interface CourseService {
	
	public Course addCourse(Course course);

	public Course getCourse(int id);
	
	public List<Course> getAllCourses();
	
	public Course updateCourse(Course course,int id);
	
	public void deleteCourse(int id);
	
	public Course addStudentToCourse(int courseid,int studentid);
}
