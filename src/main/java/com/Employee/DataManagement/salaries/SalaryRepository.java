package com.Employee.DataManagement.salaries;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Transactional
public interface SalaryRepository extends CrudRepository<Salary, EmbeddedKeyId> {
	//@org.springframework.data.jpa.repository.Query("SELECT emp_no, salary, from_date, to_date FROM employees.salaries where emp_no=:emp_no")
	public List<Salary> findByEmbeddedKeyIdEmployeeEmpNo(@Param("emp_no") Integer emp_no);
	public Salary findByEmbeddedKeyIdFromeDate(Date frome_date);
	public List<Salary> findByToDate(Date to_date);
	
	public void deleteByEmbeddedKeyIdEmployeeEmpNo(Integer emp_no);
	public void deleteByEmbeddedKeyIdFromeDate(Date frome_date);
}