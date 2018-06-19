package com.bridgelabz.hcql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.bridgelabz.model.Employee;
import com.bridgelabz.util.HibernateUtil;

public class HcqlMain {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		//get list of all employee
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Employee.class);
		List<Employee> list = criteria.list();
		for (Employee employee : list) {
			System.out.println(employee.getId()+" "+employee.getName()+" "+employee.getCity()+" "+employee.getSalary());
		}
		
		//get with id
		criteria = session.createCriteria(Employee.class).add(Restrictions.eq("id", 1));
		Employee employee = (Employee) criteria.uniqueResult();
		System.out.println(employee);
		
		//order
		criteria = session.createCriteria(Employee.class).addOrder(Order.desc("id"));
		List<Employee> list1 = criteria.list();
		for (Employee employee2 : list1) {
			System.out.println(employee2.getId()+" "+employee2.getName()+" "+employee2.getCity()+" "+employee2.getSalary());
		}
		
		//Pagination
		
	}
}
