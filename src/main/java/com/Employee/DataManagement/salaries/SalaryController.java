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
@RequestMapping("employees/{emp_no}/salaries")
public class SalaryController {
	
	@Autowired
	private SalaryService salaryService;
	
	@RequestMapping(method=RequestMethod.GET, value="")
	public @ResponseBody List<Salary> getSalariesByEmp_no(@PathVariable @Valid String emp_no) {
		Integer empNo = Integer.parseInt(emp_no);
		return salaryService.getSalariesByEmp_no(empNo);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/from_date_{from_date}")
	// string date format should be like 1992-02-13 (yyyy-MM-dd)
	public @ResponseBody List<Salary> getSalariesByFromDate(@PathVariable("emp_no") String empNo, @PathVariable("from_date") String fromDate) throws ParseException {
		java.sql.Date sqlDate = salaryService.str2SDate(fromDate);
		Integer empNoInteger = Integer.parseInt(empNo);
		return salaryService.getSalariesByFromDate(sqlDate, empNoInteger);
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/to_date_{to_date}")
	public @ResponseBody List<Salary> getSalariesByToDate(@PathVariable("to_date") String toDate) throws ParseException {
		java.sql.Date sqlDate = salaryService.str2SDate(toDate);
		return salaryService.getSalariesByToDate(sqlDate);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="")
	public void addSalary(@RequestBody Salary salary, @PathVariable("emp_no") String empNo) {
		Integer empNoInteger = Integer.parseInt(empNo);
		salary.setEmbeddedKeyId(new EmbeddedKeyId(salary.getEmbeddedKeyId().getFromeDate(), new Employee(empNoInteger, null, null, null, null, null)));
		salaryService.addSalary(salary);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/from_date_{from_date}")
	public void updateSalary(@RequestBody Salary salary, @PathVariable("emp_no") String empNo, @PathVariable("frome_date") String fromDate) throws ParseException {
		Integer _empNo = Integer.parseInt(empNo);
		salary.setEmbeddedKeyId(new EmbeddedKeyId(salary.getEmbeddedKeyId().getFromeDate(), new Employee(_empNo, null, null, null, null, null)));
		salaryService.updateSalary(salary);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/from_date_{from_date}")
	public void deleteSalayByFromDate(@PathVariable("from_date") String fromeDate, @PathVariable("emp_no") Integer empNo) throws ParseException {
		java.sql.Date sqlDate = salaryService.str2SDate(fromeDate);
		salaryService.deleteSalariesByFromDate(sqlDate);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="")
	public void deleteAllSalariesUnderEmployee(@PathVariable("emp_no") String empNo) {
		Integer intEmpNo = Integer.parseInt(empNo);
		salaryService.deleteAllSalariesUnderEmployee(intEmpNo);
	}
	

}
