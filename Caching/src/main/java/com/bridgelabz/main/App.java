package com.bridgelabz.main;

import org.hibernate.Session;

import com.bridgelabz.model.Employee;
import com.bridgelabz.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	session.beginTransaction();
    	
    	Session session2 = HibernateUtil.getSessionFactory().openSession();
    	session2.beginTransaction();
    	try {
			
    		Employee emp = session.load(Employee.class, new Integer(1));
    		System.out.println(emp);
    		
    		//session.clear();
    		//session.evict(emp);
    		
    		//fetching from first level
    		Employee emp2 = session.load(Employee.class, new Integer(1));
    		System.out.println(emp2);
    		
    		//fetching from session2's first level cache
    		Employee emp3 = session2.load(Employee.class, new Integer(1));
    		System.out.println(emp3);
		} finally {
			session.getTransaction().commit();
						
			session2.getTransaction().commit();
			HibernateUtil.shutdown();
		}
    }
}
