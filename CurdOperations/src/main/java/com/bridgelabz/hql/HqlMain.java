package com.bridgelabz.hql;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.bridgelabz.model.Employee;
import com.bridgelabz.util.HibernateUtil;

public class HqlMain {

	void insert(Employee emp) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(emp);
			System.out.println("Employee Inserted Sucessfully:" + emp.getName());
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	void displayAll() {

		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();

			String querySelect = "from Employee";
			Query query = session.createQuery(querySelect);
			List<Employee> list = query.list();
			for (Employee employee : list) {
				System.out.println(employee.getId()+" "+employee.getName()+" "+employee.getCity()+" "+employee.getSalary());
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	void displayById(Employee employee) {
		int id = employee.getId();
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			String querySelect = "from Employee where id =: id";

			Query query = session.createQuery(querySelect);
			query.setParameter("id", id);

			Employee emp = (Employee) query.uniqueResult();
			System.out.println(emp);
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	void update(Employee employee) {

		String name = employee.getName();
		int id = employee.getId();
		Session session = null;
		Transaction transaction = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			String queryUpdate = "update Employee set name =: name where id =: id";
			Query query = session.createQuery(queryUpdate);
			query.setParameter("id", id);
			query.setParameter("name", name);
			int result = query.executeUpdate();
			Employee emp = session.get(Employee.class, id);
			System.out.println(result+" "+emp);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	void deleteById(Employee employee) {
		int id = employee.getId();
		Session session = null;
		Transaction transaction = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			String queryUpdate = "delete from Employee where id =: id";
			Query query = session.createQuery(queryUpdate);
			query.setParameter("id", id);
			int result = query.executeUpdate();
			System.out.println("Deleted Sucessfully"+result);
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static void main(String[] args) {
		HqlMain app = new HqlMain();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choices:");
		do {
			System.out.println("1.Insert\n2.Update\n3.Delete\n4.View All\n5.View By Id");
			
			switch (scanner.nextInt()) {
			case 1:
				Employee emp = new Employee();
				System.out.println("Enter name:");
				emp.setName(scanner.next());
				System.out.println("Enter city:");
				emp.setCity(scanner.next());
				System.out.println("Enter Salary:");
				emp.setSalary(scanner.nextInt());
				app.insert(emp);
				break;

			case 2:
				Employee emp1 = new Employee();
				System.out.println("Enter id:");
				emp1.setId(scanner.nextInt());
				System.out.println("Enter new name:");
				emp1.setName(scanner.next());
				app.update(emp1);
				break;
				
			case 3:
				Employee emp2 = new Employee();
				System.out.println("Enter id:");
				emp2.setId(scanner.nextInt());
				app.deleteById(emp2);
				break;
				
			case 4:
				System.out.println("List of Employees");
				app.displayAll();
				break;
			
			case 5:
				Employee emp3 = new Employee();
				System.out.println("Enter id:");
				emp3.setId(scanner.nextInt());
				app.displayById(emp3);
				break;
				
			default:
				scanner.close();
				break;
			}
			
		} while (true);

	}

}
