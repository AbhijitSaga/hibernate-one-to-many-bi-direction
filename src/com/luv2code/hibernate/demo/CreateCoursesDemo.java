package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Course;
import com.entity.Instructor;

public class CreateCoursesDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();
			
			//get the instructor from database
			int theId=6;
			Instructor tempInstructor=session.get(Instructor.class, theId);
			
			//create some courses
			Course theCourse=new Course(" core Java masterclass ");
			Course theCourse1=new Course(" Oracle masterclass ");
			Course theCourse2=new Course("MySql class ");
			Course theCourse3=new Course("C#  masterclass ");
			
			//add courses to instructor
			tempInstructor.add(theCourse);
			tempInstructor.add(theCourse1);
			tempInstructor.add(theCourse2);
			tempInstructor.add(theCourse3);
			
			//save the courses
			  session.save(theCourse);
			  session.save(theCourse1);
			  session.save(theCourse2);
			  session.save(theCourse3);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("done.....");
		} catch (Exception ex) {
			ex.getStackTrace();

		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
