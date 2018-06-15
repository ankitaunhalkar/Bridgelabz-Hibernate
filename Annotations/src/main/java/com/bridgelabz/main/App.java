package com.bridgelabz.main;

import org.hibernate.Session;

import com.bridgelabz.model.Customer;
import com.bridgelabz.util.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {
    	Customer customer = new Customer();
    	
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	
    	session.beginTransaction();
    	
    	customer.setId(1);
    	customer.setName("Ankita");
    	customer.setCity("Mumbai");
    	
    	session.save(customer);
    	
    	session.getTransaction().commit();
    	
    	session.close();
    	
    }
}
