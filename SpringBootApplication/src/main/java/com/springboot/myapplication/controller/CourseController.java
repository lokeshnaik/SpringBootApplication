package com.springboot.myapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.myapplication.entity.Course;
import com.springboot.myapplication.repository.CourseRepository;
import com.springboot.myapplication.service.CourseService;

@RestController
@RequestMapping("/education/course")
public class CourseController 
{
   @Autowired
	private CourseService courseService;
   
   @PostMapping("/addcourse")
   private Course addCourse(@RequestBody Course course)
   {
	    course=courseService.addCourse(course);
	   return course;
   }
	
   @GetMapping("/getcourse/{id}")
   private Course getCourse(@PathVariable int id)
   {
	 Course course=courseService.getCourse(id);
	   
	   if(course==null)
	   {

		   System.out.println("Course with id "+id+" is not available"); 
		   return null;
	   }
	   
	  return course; 
   }
   
   @GetMapping("/getallcourses")
   private List<Course> getAllCourses()
   {
	   List<Course> course=courseService.getAllCourses(); 
	   return course;
   }
   
   @PutMapping("/updatecourse/{id}")
   private Course updateCourse(@RequestBody Course course,@PathVariable int id) throws Exception
   {
	   if(course==null)
	   {
		   throw new Exception("Course of given id "+id+" is not available to update");
	   }
	   
	 Course course1=courseService.updateCourse(course,id);
	 return course1;  
   }
   
   @DeleteMapping("/deletecourse/{id}")
   private String deleteCourse(@PathVariable int id)
   {
	   Course course=courseService.getCourse(id);
	   if(course==null)
	   {
		   String string="The id which you entered "+id+" is not avaibale in the database to delete";
		   return string;
	   }
	   courseService.deleteCourse(id);
	   String string1="The course contain id which you entered "+id+" got  deleted from the database";
	   return string1;
   }
}
