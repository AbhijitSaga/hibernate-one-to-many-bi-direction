package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Instructor;

public class GetInstructorCourseDemo {
public static void main(String[] args) {
	

	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	
	Session session=sessionFactory.getCurrentSession();
	try {
		//transaction start
		session.beginTransaction();
		
		//get the instructor from database
		int theId=6;
		Instructor tempInstructor=session.get(Instructor.class, theId);
		
		System.out.println("Instructor: "+tempInstructor );
		
		//get course for the instructor
		System.out.println("Courses: "+ tempInstructor.getCourses() );
		
				
		//add courses to instructor
		
		// commit transaction 
		session.getTransaction().commit();
		
		
	}catch(Exception ex) {
		ex.getStackTrace();
	}finally {
		session.close();
	}
}
}

