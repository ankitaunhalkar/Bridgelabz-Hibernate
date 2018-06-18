package com.bridgelabz.main;

import org.hibernate.Session;

import com.bridgelabz.one2one.Car;
import com.bridgelabz.one2one.Engine;
import com.bridgelabz.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class Appone2one 
{
    public static void main( String[] args )
    {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	session.beginTransaction();
    	
    	Car car = new Car();
    	car.setName("BMW");
    	car.setColor("Grey");
    	
    	Engine engine = new Engine();
    	engine.setModel("MV02");
    	engine.setSize("large");
    	
    	/* one2one unidirectional */
    	//car.setEngine(engine);
    	
    	/* one2one bidirectional */
    	engine.setCar(car);
    	car.setEngine(engine);
    	
    	session.save(car);
    	
    	session.getTransaction().commit();
    	session.close();
    	
    	HibernateUtil.shutdown();
    }
}
