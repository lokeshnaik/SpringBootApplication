package com.springboot.myapplication.serviceimplmentation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.myapplication.entity.Course;
import com.springboot.myapplication.repository.CourseRepository;
import com.springboot.myapplication.service.CourseService;

@Service
@Transactional
public class CourseServiceImp implements CourseService
{
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public Course addCourse(Course course) {
		Course course1;
		course1=courseRepository.addNewCourse(course);
		return course1;
	}

	@Override
	public Course getCourse(int id) {
		Course course=courseRepository.getStudentDetailById(id);
		return course;
	}

	@Override
	public List<Course> getAllCourses() {
		List<Course> course=courseRepository.getAllCoursesAvailable();
		return course;
	}

	@Override
	@Transactional
	public Course updateCourse(Course course, int id) {
		Course course1=courseRepository.updateCourseDetails(course,id);
		return course1;
	}

	@Override
	public void deleteCourse(int id) {
		courseRepository.deleteWholeCourse(id);

		return ;

	}

	@Override
	public Course addStudentToCourse(int courseid, int studentid) {
		Course course=courseRepository.addStudentInCourse(courseid,studentid);
		return course;
	}


}
