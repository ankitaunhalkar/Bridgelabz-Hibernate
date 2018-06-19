package com.bridgelabz.session;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bridgelabz.model.Employee;
import com.bridgelabz.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class SessionApp {
	void insert(Employee emp) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// session.save(emp);
			session.persist(emp);
			System.out.println("Employee Inserted:" + emp.getName());
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

	void delete(Employee emp) {
		System.out.println(emp.getName());

		Session session = null;
		Transaction transaction = null;
		try {
			System.out.println(emp.getName());
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(emp);
			System.out.println("Employee Deleted:" + emp.getName());
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

	void view() {

		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Employee emp = session.load(Employee.class, 1);
			Employee emp1 = session.get(Employee.class, 3);// f not found it returns null

			System.out.println(emp);
			System.out.println(emp1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	void update() {

		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Employee emp = session.load(Employee.class, 1);

			transaction = session.beginTransaction();
			emp.setName("Madhuri");
			session.update(emp);
			transaction.commit();
			System.out.println(emp);

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
		SessionApp app = new SessionApp();

		/* Insert */
		Employee employee = new Employee();
		// employee.setId(1);
		employee.setName("Ankita");
		employee.setCity("Mumbai");
		employee.setSalary(2000);
		// app.insert(employee);

		/* Delete */
		Employee employee2 = new Employee();
		employee2.setId(2);
		employee2.setName("Shweta");
		employee2.setCity("Mumbai");
		employee.setSalary(3000);
		// app.insert(employee2);
		// app.delete(employee2);

		app.view();

		// app.update();
	}
}
