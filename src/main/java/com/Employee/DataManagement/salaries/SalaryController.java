package com.Employee.DataManagement.salaries;


import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.DataManagement.employees.Employee;


@RestController
@RequestMapping("employees")
public class SalaryController {
	
	@Autowired
	private SalaryService salaryService;
	
	@RequestMapping(value="/{emp_no}/salaries")
	public @ResponseBody List<Salary> getSalariesByEmp_no(@PathVariable @Valid String emp_no) {
		Integer empNo = Integer.parseInt(emp_no);
//		System.out.println("emp no: "+empNo);
		return salaryService.getSalariesByEmp_no(empNo);
	}
	
	@RequestMapping(value="/{emp_no}/salaries/from_date_{from_date}")
	// string date format should be like 1992-02-13 (yyyy-MM-dd)
	public @ResponseBody Salary getSalariesByFromDate(@PathVariable("from_date") String fromDate) throws ParseException {
		java.sql.Date sqlDate = salaryService.str2SDate(fromDate);
		return salaryService.getSalariesByFromDate(sqlDate);
	}
	
	
	@RequestMapping(value="/{emp_no}/salaries/to_date_{to_date}")
	public @ResponseBody List<Salary> getSalariesByToDate(@PathVariable("to_date") String toDate) throws ParseException {
		java.sql.Date sqlDate = salaryService.str2SDate(toDate);
		return salaryService.getSalariesByToDate(sqlDate);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/{emp_no}/salaries")
	public void addSalary(@RequestBody Salary salary, @PathVariable("emp_no") Integer empNo) {
		salary.setEmbeddedKeyId(new EmbeddedKeyId(salary.getEmbeddedKeyId().getFromeDate(), new Employee(empNo, null, null, null, null, null)));
		salaryService.addSalary(salary);;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{emp_no}/salaries/{from_date}")
	public void updateSalary(@RequestBody Salary salary, @PathVariable("emp_no") String empNo, @PathVariable("frome_date") String fromDate) throws ParseException {
		Integer _empNo = Integer.parseInt(empNo);
		salary.setEmbeddedKeyId(new EmbeddedKeyId(salary.getEmbeddedKeyId().getFromeDate(), new Employee(_empNo, null, null, null, null, null)));
		salaryService.updateSalary(salary);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{emp_no}/salaries/{from_date}")
	public void deleteSalayByFromDate(@PathVariable("from_date") String fromeDate, @PathVariable("emp_no") Integer empNo) throws ParseException {
		java.sql.Date sqlDate = salaryService.str2SDate(fromeDate);
		salaryService.deleteSalariesByFromDate(sqlDate);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{emp_no}/salaries")
	public void deleteAllSalariesUnderEmployee(@PathVariable String empNo) {
		Integer intEmpNo = Integer.parseInt(empNo);
		salaryService.deleteAllSalariesUnderEmployee(intEmpNo);
	}
	

}
