package com.Employee.DataManagement.titles;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface TitleRepository extends CrudRepository<Title, EmbeddedKey> {
	public List<Title> findByEmbeddedKeyEmployeeEmpNo(Integer emp_no);
	public List<Title> findByEmbeddedKeyFromDate(Date from_date);
	public List<Title> findByEmbeddedKeyTitle(String title);
	
	public void deleteByEmbeddedKeyEmployeeEmpNo(Integer emp_no);
}