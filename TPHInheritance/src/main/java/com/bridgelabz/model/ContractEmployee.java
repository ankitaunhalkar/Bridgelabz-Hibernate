package com.bridgelabz.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "contract")
public class ContractEmployee extends Employee {
	
	@Column (name = "pay_per_hour")
	private double pay_per_hour;
	
	@Column (name = "contract_period")
	private String contract_period;

	public double getPay_per_hour() {
		return pay_per_hour;
	}

	public void setPay_per_hour(double d) {
		this.pay_per_hour = d;
	}

	public String getContract_period() {
		return contract_period;
	}

	public void setContract_period(String contract_period) {
		this.contract_period = contract_period;
	}
	
	
}
