package com.Employee.DataManagement.employees;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@javax.persistence.Table(name="employees")
public class Employee {
	enum genderENU {
		M, F
	}
	@Id
	@Column(name="emp_no", nullable = false)
	private Integer empNo;
	
	@Column(nullable = false)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="EST")
	private Date birth_date;
	
	@Column(nullable = false)
	private String first_name;
	
	@Column(nullable = false)
	private String last_name;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private genderENU gender;
	
	@Column(nullable = false)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="EST")
	private Date hire_date;
	
	public Employee(Integer emp_no, Date birth_date, String first_name, String last_name, genderENU gender, Date hire_date) {
		this.empNo = emp_no;
		this.birth_date = birth_date;
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.hire_date = hire_date;
	}
	
	protected Employee() {}
	
	public Integer getEmp_no() {
		return empNo;
	}
	public void setEmp_no(Integer emp_no) {
		this.empNo = emp_no;
	}
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public genderENU getGender() {
		return gender;
	}
	public void setGender(genderENU gender) {
		this.gender = gender;
	}
	public Date getHire_date() {
		return hire_date;
	}
	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}
}
