package com.Employee.DataManagement.titles;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.Employee.DataManagement.employees.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="titles")
public class Title implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmbeddedKey embeddedKey;
	
	@Column(name="to_date")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="EST")
	private Date toDate;

	public Title(Integer empNo, String title, Date fromDate, Date toDate) {
		super();
		this.embeddedKey = new EmbeddedKey(new Employee(empNo, null, null, null, null, null), title, fromDate);
		this.toDate = toDate;
	}
	protected Title() {}
	
	/**
	 * @return the embeddedKey
	 */
	public EmbeddedKey getEmbeddedKey() {
		return embeddedKey;
	}

	/**
	 * @param embeddedKey the embeddedKey to set
	 */
	public void setEmbeddedKey(EmbeddedKey embeddedKey) {
		this.embeddedKey = embeddedKey;
	}

	/**
	 * @return the toDate
	 */
	public java.util.Date getToDate() {
		return toDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
}
