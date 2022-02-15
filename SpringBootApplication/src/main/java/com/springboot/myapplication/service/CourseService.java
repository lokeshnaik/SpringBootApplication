package com.springboot.myapplication.service;

import java.util.List;

import com.springboot.myapplication.dto.CourseDto;
import com.springboot.myapplication.dto.CourseDtoWithId;
import com.springboot.myapplication.entity.Course;

public interface CourseService {

	public CourseDto addCourse(CourseDto course);

	public CourseDtoWithId getCourse(int id);

	public List<CourseDtoWithId> getAllCourses();

	public Course updateCourse(Course course,int id);

	public void deleteCourse(int id);

	public Course addStudentToCourse(int courseid,int studentid);
}
