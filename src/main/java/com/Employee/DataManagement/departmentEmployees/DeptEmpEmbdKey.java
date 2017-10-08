package com.Employee.DataManagement.departmentEmployees;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.Employee.DataManagement.departments.Department;

@Embeddable
public class DeptEmpEmbdKey implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="dept_no", referencedColumnName="dept_no")
	private Department department;

	public DeptEmpEmbdKey(Department department) {
		super();
		this.department = department;
	}

	protected DeptEmpEmbdKey() {
		super();
	}

	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
