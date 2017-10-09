package com.Employee.DataManagement.salaries;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface SalaryRepository extends CrudRepository<Salary, EmbeddedKeyId> {
	public List<Salary> findByEmbeddedKeyIdEmployeeEmpNo(Integer emp_no);
	public Salary findByEmbeddedKeyIdFromDate(Date from_date);
	public List<Salary> findByToDate(Date to_date);
	
	public void deleteByEmbeddedKeyIdEmployeeEmpNo(Integer emp_no);
	public void deleteByEmbeddedKeyIdFromDate(Date from_date);
}