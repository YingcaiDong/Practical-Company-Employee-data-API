package com.Employee.DataManagement.salaries;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.Employee.DataManagement.employees.Employee;

@Embeddable
public class EmbeddedKeyId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "from_date")
	private Date fromeDate;
	 
	@ManyToOne
	@JoinColumn(name="emp_no", referencedColumnName="emp_no")
	private Employee employee;

	public EmbeddedKeyId(Date fromeDate, Employee employee) {
		super();
		this.fromeDate = fromeDate;
		this.employee = employee;
	}

	protected EmbeddedKeyId() {
		super();
	}

	public Date getFromeDate() {
		return fromeDate;
	}

	public void setFromeDate(Date fromeDate) {
		this.fromeDate = fromeDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
