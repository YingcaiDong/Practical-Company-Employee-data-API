package com.Employee.DataManagement.salaries;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {
	
	@Autowired
	private SalaryRepository salaryRepository;
	
	public Salary getSalariesByFromDate(Date _from) {
		return salaryRepository.findByEmbeddedKeyIdFromeDate(_from);
	}

	public List<Salary> getSalariesByToDate(Date _end) {
		return salaryRepository.findByToDate(_end);
	}
	
	public List<Salary> getSalariesByEmp_no(Integer emp_no) {
		return salaryRepository.findByEmbeddedKeyIdEmployeeEmpNo(emp_no);
	}

	public void addSalary(Salary salary) {
		salaryRepository.save(salary);
	}

	public void updateSalary(Salary salary) {
		salaryRepository.save(salary);
	}

	public void deleteAllSalariesUnderEmployee(Integer empId) {
		salaryRepository.deleteByEmbeddedKeyIdEmployeeEmpNo(empId);
	}
	
	public void deleteSalariesByFromDate(Date date) {
		salaryRepository.deleteByEmbeddedKeyIdFromeDate(date);
	}
	
	// string date format should be like 1992-02-13 (yyyy-MM-dd)
	public Date str2SDate(String strDate) throws ParseException {
		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sDateFormat.parse(strDate);
		return new java.sql.Date(date.getTime());
	}
}
