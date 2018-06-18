package com.bridgelabz.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

	@Entity
	@Table(name = "executivetps")
	@PrimaryKeyJoinColumn(name="Id")  
	public class Executive extends Employee{

		@Column(name = "salary")
		private double salary;

		@Column(name = "experience")
		private int expirence;

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

		public int getExpirence() {
			return expirence;
		}

		public void setExpirence(int expirence) {
			this.expirence = expirence;
		}

}
