package com.Employee.DataManagement.departmentEmployees;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.Employee.DataManagement.departments.Department;
import com.Employee.DataManagement.employees.Employee;

@Embeddable
public class DeptEmpEmbdKey implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne
	@Column(name="emp_no", nullable=false)
	
	@ManyToOne
	@JoinColumn(name="dept_no", referencedColumnName="dept_no")
	private Department department;
	
	
}
