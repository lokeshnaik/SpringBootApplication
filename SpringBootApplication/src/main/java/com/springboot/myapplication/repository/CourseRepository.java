package com.springboot.myapplication.repository;

import java.util.List;

import com.springboot.myapplication.entity.Course;

public interface CourseRepository 
{
	public Course addNewCourse(Course course);
	
	public Course getStudentDetailById(int id);
	
	public List<Course> getAllCoursesAvailable();
	
	public Course updateCourseDetails(Course course,int id);
	
	public void deleteWholeCourse(int id);

}
