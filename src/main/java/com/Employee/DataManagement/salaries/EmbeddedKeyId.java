package com.Employee.DataManagement.salaries;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.Employee.DataManagement.employees.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;

@Embeddable
public class EmbeddedKeyId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7387776295438195037L;

	@Column(name = "from_date")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="EST")
	private Date fromDate;
	 
	@ManyToOne
	@JoinColumn(name="emp_no", referencedColumnName="emp_no")
	private Employee employee;

	public EmbeddedKeyId(Date fromDate, Employee employee) {
		super();
		this.fromDate = fromDate;
		this.employee = employee;
	}

	protected EmbeddedKeyId() {
		super();
	}

	public Date getFromeDate() {
		return fromDate;
	}

	public void setFromeDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
