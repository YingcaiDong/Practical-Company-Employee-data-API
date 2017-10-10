package com.Employee.DataManagement.titles;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.Employee.DataManagement.employees.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;

@Embeddable
public class EmbeddedKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3932787714653257528L;

	@OneToOne
	@JoinColumn(name = "emp_no", referencedColumnName="emp_no", nullable=false)
	private Employee employee;
	
	@Column(name="title", nullable=false)
	private String title;
	
	@Column(name="from_date", nullable=false)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="EST")
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
