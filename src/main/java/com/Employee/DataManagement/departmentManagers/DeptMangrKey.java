package com.Employee.DataManagement.departmentManagers;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.Employee.DataManagement.departments.Department;
import com.Employee.DataManagement.employees.Employee;

@Embeddable
public class DeptMangrKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6292021607574943674L;
	
	@ManyToOne
	@JoinColumn(name="dept_no", referencedColumnName="dept_no")
	private Department department;

	@ManyToOne
	@JoinColumn(name="emp_no", referencedColumnName="emp_no")
	private Employee employee;

	public DeptMangrKey(Department department, Employee employee) {
		super();
		this.department = department;
		this.employee = employee;
	}

	protected DeptMangrKey() {
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
	
}
