package com.Employee.DataManagement.salaries;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.Employee.DataManagement.employees.Employee;

@Entity
@javax.persistence.Table(name="salaries")
public class Salary {
	@EmbeddedId
	private EmbeddedKeyId embeddedKeyId;
	
	@Column(name="salary", nullable = false)
	private Integer salary;
	
	@Column(name = "to_date", nullable = false)
	private Date toDate;
	
	public Salary(Integer emp_no, Integer salary, Date from_date, Date to_date) {
		super();
		this.salary = salary;
		this.toDate = to_date;
		
		this.embeddedKeyId = new EmbeddedKeyId(from_date, new Employee(emp_no, null, null, null, null, null));
	}
	
	protected Salary() {}

	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public EmbeddedKeyId getEmbeddedKeyId() {
		return embeddedKeyId;
	}
	public void setEmbeddedKeyId(EmbeddedKeyId embeddedKeyId) {
		this.embeddedKeyId = embeddedKeyId;
	}

	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
}   