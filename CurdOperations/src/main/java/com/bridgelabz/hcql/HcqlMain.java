package com.bridgelabz.hcql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
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
		criteria = session.createCriteria(Employee.class).setFirstResult(0).setMaxResults(5);
		List<Employee> list2 = criteria.list();
		for (Employee employee2 : list2) {
			System.out.println(employee2.getId()+" "+employee2.getName()+" "+employee2.getCity()+" "+employee2.getSalary());
		}
		
		//like
		List<Employee> emplist = session.createCriteria(Employee.class).add(Restrictions.like("name", "%i%")).list();
		for (Employee employee2 : emplist) {
			System.out.println(employee2.getId()+" "+employee2.getName()+" "+employee2.getCity()+" "+employee2.getSalary());
		}
		
		//projection
		long count = (Long) session.createCriteria(Employee.class)
				.setProjection(Projections.rowCount())
				.uniqueResult();
		System.out.println(count);
		
		//sum, aggregation functions
		Object sum = (Object)session.createCriteria(Employee.class).setProjection(Projections.sum("salary")).uniqueResult();	
		System.out.println(sum);
		
		//projection column
		ProjectionList coList = Projections.projectionList().add(Projections.property("name"));
		List<Object> list11 =criteria.setProjection(coList).list();
		for (Object employee2 : list11) {
			System.out.println(employee2);
		}
	}
}
