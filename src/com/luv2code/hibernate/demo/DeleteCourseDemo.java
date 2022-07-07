package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Course;

public class DeleteCourseDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			// start a transaction
			session.beginTransaction();

			// get a course
             int theId=4;
             Course tempCourse=session.get(Course.class, theId);
             
			// delete course
             System.out.println("Deleting course: "+ tempCourse);
              session.delete(tempCourse);
             
			// commit transaction
			session.getTransaction().commit();
		} catch (Exception ex) {
			ex.getStackTrace();
		} finally {
			session.close();
		}
	}
}
