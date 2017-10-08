package com.Employee.DataManagement.departmentEmployees;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.Employee.DataManagement.departments.Department;

@Entity
@Table(name="dept_emp")
public class DepartmentEmployee {
	
	@Id
	@Column(name="emp_no", nullable=false)
	private Integer empNo;
	
	@EmbeddedId
	private DeptEmpEmbdKey deeKey;
	
	@Column(name="from_date", nullable=true)
	private Date fromDate;
	
	@Column(name="to_date", nullable=true)
	private Date toDate;

	public DepartmentEmployee(Integer emp_no, String deptNo, Date fromDate, Date toDate) {
		super();
		this.empNo = emp_no;
		this.deeKey = new DeptEmpEmbdKey(new Department(deptNo, null));
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	protected DepartmentEmployee() {
		super();
	}

	/**
	 * @return the empNo
	 */
	public Integer getEmpNo() {
		return empNo;
	}

	/**
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
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
