package com.luv2code.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Instructor;

 public class HibernateUtil {
	 
private HibernateUtil() {   }

private	static SessionFactory sessionFactory=null;
	
	static SessionFactory getSessionFactory() {
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Course.class);
		configuration.addAnnotatedClass(Instructor.class);
		
		
		
		if(sessionFactory==null) {
			sessionFactory=configuration.buildSessionFactory();
		}
		return sessionFactory;
	}
}
