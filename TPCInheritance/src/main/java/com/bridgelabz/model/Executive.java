package com.bridgelabz.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "executivetpc1")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "id")),
		@AttributeOverride(name = "name", column = @Column(name = "name")) })
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
