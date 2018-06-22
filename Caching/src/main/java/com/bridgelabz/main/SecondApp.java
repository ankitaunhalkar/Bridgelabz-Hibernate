package com.bridgelabz.main;

import org.hibernate.Session;

import com.bridgelabz.model.Employee;
import com.bridgelabz.util.HibernateUtil;

public class SecondApp {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
    	session.beginTransaction();
    	
    	
    	try {
			
    		Employee employee = session.load(Employee.class, new Integer(1));
    		System.out.println(employee);
    		
    		//session.clear();
    		//session.evict(employee);
    		
    		//fetching entity from first level again
    		employee = session.load(Employee.class, new Integer(1));
    		System.out.println(employee);
    		
    		session.getTransaction().commit();
			session.close();
			
			//fetching entity from second level
			Session session2 = HibernateUtil.getSessionFactory().openSession();
	    	session2.beginTransaction();
    		employee = session2.load(Employee.class, new Integer(1));
    		System.out.println(employee);
    		
    		session2.getTransaction().commit();
    		session2.close();
		} finally {
			
			HibernateUtil.shutdown();
		}

	}
}
