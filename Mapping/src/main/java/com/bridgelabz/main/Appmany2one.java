package com.bridgelabz.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.bridgelabz.many2one.Customer;
import com.bridgelabz.many2one.Vendor;
import com.bridgelabz.util.HibernateUtil;

public class Appmany2one {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Vendor vendor = new Vendor();
		vendor.setName("Samsung");
		
		Customer customer1 = new Customer();
		customer1.setName("John");
		customer1.setVendor(vendor);
		
		Customer customer2 = new Customer();
		customer2.setName("Joey");
		customer2.setVendor(vendor);
		
		List<Customer> customerlist = new ArrayList<Customer>();
		customerlist.add(customer1);
		customerlist.add(customer2);
		vendor.setList(customerlist);
		
		session.save(vendor);
		session.save(customer1);
		session.save(customer2);
		
		session.getTransaction().commit();
		session.close();
		
		HibernateUtil.shutdown();
	}
}
