package com.Employee.DataManagement.departmentManagers;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="dept_manager")
public class DepartmentManager {
	@EmbeddedId
	private DeptMangrKey deptMangrKey;
	
	@Column(name="from_date", nullable=false)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="EST")
	private Date fromDate;
	
	@Column(name="to_date", nullable=false)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="EST")
	private Date toDate;

	public DepartmentManager(DeptMangrKey deptMangrKey, Date fromDate, Date toDate) {
		super();
		this.deptMangrKey = deptMangrKey;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	protected DepartmentManager() {
		super();
	}

	/**
	 * @return the deptMangrKey
	 */
	public DeptMangrKey getDeptMangrKey() {
		return deptMangrKey;
	}

	/**
	 * @param deptMangrKey the deptMangrKey to set
	 */
	public void setDeptMangrKey(DeptMangrKey deptMangrKey) {
		this.deptMangrKey = deptMangrKey;
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
