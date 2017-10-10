package com.Employee.DataManagement.departmentEmployees;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.Employee.DataManagement.departments.Department;
import com.Employee.DataManagement.employees.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="dept_emp")
public class DepartmentEmployee {
	
	@EmbeddedId
	private DeptEmpEmbdKey deeKey;
	
	@Column(name="from_date", nullable=true)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="EST")
	private Date fromDate;
	
	@Column(name="to_date", nullable=true)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="EST")
	private Date toDate;

	public DepartmentEmployee(Integer emp_no, String deptNo, Date fromDate, Date toDate) {
		super();
		this.deeKey = new DeptEmpEmbdKey(new Department(deptNo, null), new Employee(emp_no, null, null, null, null, null));
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	protected DepartmentEmployee() {
		super();
	}

	/**
	 * @return the deeKey
	 */
	public DeptEmpEmbdKey getDeeKey() {
		return deeKey;
	}

	/**
	 * @param deeKey the deeKey to set
	 */
	public void setDeeKey(DeptEmpEmbdKey deeKey) {
		this.deeKey = deeKey;
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

	/**
	 * @return the toDate
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
}
