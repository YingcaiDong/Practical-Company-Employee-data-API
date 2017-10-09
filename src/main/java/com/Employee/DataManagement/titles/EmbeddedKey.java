package com.Employee.DataManagement.titles;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;

import com.Employee.DataManagement.employees.Employee;

@Embeddable
public class EmbeddedKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JoinColumn(name = "emp_no", referencedColumnName="emp_no", nullable=false)
	private Employee employee;
	
	@Column(name="title", nullable=false)
	private String title;
	
	@Column(name="from_date", nullable=false)
	private Date fromDate;
	
	protected EmbeddedKey() {
		super();
	}

	public EmbeddedKey(Employee employee, String title, Date fromDate) {
		super();
		this.employee = employee;
		this.title = title;
		this.fromDate = fromDate;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the fromDate
	 */
	public Date getFromDate() {
		return fromDate;
	}

	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
}
