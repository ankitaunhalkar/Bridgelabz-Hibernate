package com.bridgelabz.main;

import org.hibernate.Session;

import com.bridgelabz.model.ContractEmployee;
import com.bridgelabz.model.Employee;
import com.bridgelabz.model.RegularEmployee;
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
      e1.setName("Sid");
      
      ContractEmployee c1 = new ContractEmployee();
      c1.setName("Ankita");
      c1.setContract_period("1 year");
      c1.setPay_per_hour(5.5);
      
      RegularEmployee r1 = new RegularEmployee();
      r1.setName("Shweta");
      r1.setSalary(2500);
      r1.setBonus(500);
      
      session.save(e1);
      session.save(c1);
      session.save(r1);
      
      session.getTransaction().commit();
      
      session.close();
      
    }
}
