package com.bridgelabz.main;

import org.hibernate.Session;

import com.bridgelabz.model.Employee;
import com.bridgelabz.model.Executive;
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
    	
    	Employee e1 = new Employee();
    	e1.setName("Ankita");

    	Executive ex = new Executive();
    	ex.setName("Ankita");
    	ex.setSalary(45000);
    	ex.setExpirence(5);
    	
    	session.save(e1);
    	session.save(ex);
    	
    	session.getTransaction().commit();
    	session.close();
    	
    	System.out.println("zhala!!!");
    }
}
