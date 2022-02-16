package com.springboot.myapplication.serviceimplmentation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.myapplication.dto.CourseDto;
import com.springboot.myapplication.dto.CourseDtoWithId;
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
	public CourseDto addCourse(CourseDto course) {
		Course course1=new Course();
		course1.setCourseName(course.getCourseName());
	//	course1.setCourseid(course.getCourseid());
		course1.setCourseDuration(course.getCourseDuration());
		course1.setCourseFee(course.getCourseFee());
		course1.setCourseStartdate(course.getCourseStartdate());
		courseRepository.addNewCourse(course1);
		return course;
	}

	@Override
	public CourseDtoWithId getCourse(int id) {
		Course course=courseRepository.getStudentDetailById(id);
		CourseDtoWithId course1=new CourseDtoWithId();
		course1.setCourseDuration(course.getCourseDuration());
        course1.setCourseFee(course.getCourseFee());
        course1.setCourseid(course.getCourseid());
        course1.setCourseName(course.getCourseName());
        course1.setCourseStartdate(course.getCourseStartdate());
        return course1;
	}

	@Override
	public List<CourseDtoWithId> getAllCourses() {
		List<Course> course=courseRepository.getAllCoursesAvailable();
		List<CourseDtoWithId> coursedtoid=new ArrayList<CourseDtoWithId>();
		for(Course course1:course)
		{
			CourseDtoWithId coursedt=new CourseDtoWithId();	
			coursedt.setCourseid(course1.getCourseid());
			coursedt.setCourseDuration(course1.getCourseDuration());
			coursedt.setCourseFee(course1.getCourseFee());
			coursedt.setCourseName(course1.getCourseName());
			coursedt.setCourseStartdate(course1.getCourseStartdate());
			coursedtoid.add(coursedt);
			
		}
		return coursedtoid;
	}

	@Override
	@Transactional
	public CourseDtoWithId updateCourse(CourseDto course, int id) {
		Course cour=new Course();
		cour.setCourseid(id);
		cour.setCourseDuration(course.getCourseDuration());
		cour.setCourseFee(course.getCourseFee());
		cour.setCourseName(course.getCourseName());
		cour.setCourseStartdate(course.getCourseStartdate());
		Course course1=courseRepository.updateCourseDetails(cour,id);
		CourseDtoWithId courseid=new CourseDtoWithId();
		courseid.setCourseid(course1.getCourseid());
		courseid.setCourseDuration(course1.getCourseDuration());
		courseid.setCourseFee(course1.getCourseFee());
		courseid.setCourseName(course1.getCourseName());
		courseid.setCourseStartdate(course1.getCourseStartdate());
		return courseid;
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
