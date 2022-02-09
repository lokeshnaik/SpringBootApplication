package com.springboot.myapplication.repositoryimplementation;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.myapplication.entity.Course;
import com.springboot.myapplication.entity.Student;
import com.springboot.myapplication.repository.CourseRepository;

@Repository
public class CourseRepositoryImp  implements CourseRepository
{
    @Autowired
	private SessionFactory factory;
	
	@Override
	public Course addNewCourse(Course course) {
		
		Session session=factory.openSession();
		session.save(course);
		return course;
	}

	@Override
	public Course getStudentDetailById(int id) {
		
		Session session=factory.openSession();
		Course course=session.get(Course.class, id);
		return course;
	}

	@Override
	public List<Course> getAllCoursesAvailable() {
		Session session=factory.openSession();
		Query<Course> query=session.createQuery("from Course",Course.class);
		List<Course> course=query.getResultList();
		return course;
	}

	@Override
	public Course updateCourseDetails(Course course, int id) {
		Session session=factory.openSession();
		session.beginTransaction();
		Course course1=(Course)session.get(Course.class,id);
		if(course1!=null)
		{
		course1.setCourseName(course.getCourseName());
		course1.setCourseFee(course.getCourseFee());
		course1.setCourseDuration(course.getCourseDuration());
		course1.setCourseStartdate(course.getCourseStartdate());
		}
		session.update(course1);
		
		session.getTransaction().commit();
		return course1;
	}

	@Override
	public void deleteWholeCourse(int id) {
		Session session=factory.openSession();
		session.beginTransaction();
    	Course course=session.get(Course.class, id);
	    session.delete(course);
	    session.getTransaction().commit();
	    session.close();
	    
	    return ;
		
	}

	@Override
	public Course addStudentInCourse(int courseid, int studentid) {
	  Session session=factory.openSession();
	  session.beginTransaction();
	  Student student=session.get(Student.class, studentid);
	  Course course=session.get(Course.class, courseid);
	  course.add(student);
	  session.save(course);
	  session.getTransaction().commit();
		return course;
		
	}

}
