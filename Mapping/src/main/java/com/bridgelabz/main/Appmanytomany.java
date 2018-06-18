package com.bridgelabz.main;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.bridgelabz.many2many.Course;
import com.bridgelabz.many2many.Student;
import com.bridgelabz.util.HibernateUtil;

public class Appmanytomany {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Set<Student> studentSet = new HashSet<Student>();
		Set<Course> courseSet = new HashSet<Course>();
		
		session.beginTransaction();
		
		Course course1 = new Course();
		course1.setCname("java");
		Course course2 = new Course();
		course2.setCname(".net");
		Course course3 = new Course();
		course3.setCname("Mean");
		Course course4 = new Course();
		course4.setCname("iOS");
		courseSet.add(course1);
		courseSet.add(course2);
		courseSet.add(course3);
		courseSet.add(course4);
		
		
		Student student1 = new Student();
		student1.setSname("Ankita");
		Student student2 = new Student();
		student2.setSname("Siddy");
		Student student3 = new Student();
		student3.setSname("Shweta");
		Student student4 = new Student();
		student4.setSname("Poonam");
		studentSet.add(student1);
		studentSet.add(student2);
		studentSet.add(student3);
		studentSet.add(student4);
		
		course1.setStudentSet(studentSet);
		course3.setStudentSet(studentSet);
		
		student2.setCourseSet(courseSet);
		student4.setCourseSet(courseSet);
		
		session.save(student1);
		session.save(student2);
		session.save(student3);
		session.save(student4);
		
		session.save(course1);
		session.save(course2);
		session.save(course3);
		session.save(course4);
		
		session.getTransaction().commit();
		
		session.close();
		
		HibernateUtil.shutdown();
		
	}
}
