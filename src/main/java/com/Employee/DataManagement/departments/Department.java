package com.Employee.DataManagement.departments;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="departments")
public class Department {
	
	@Id
	@Column(name="dept_no", nullable=false)
	private String deptNo;
	
	@Column(name="dept_name", nullable=false, unique=true)
	private String deptName;

	/**
	 * @param deptNo
	 * @param deptName
	 */
	public Department(String deptNo, String deptName) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
	}

	protected Department() {
		super();
	}

	/**
	 * @return the deptNo
	 */
	public String getDeptNo() {
		return deptNo;
	}

	/**
	 * @param deptNo the deptNo to set
	 */
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
}
