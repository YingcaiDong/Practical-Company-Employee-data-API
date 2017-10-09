package com.Employee.DataManagement.titles;

import java.sql.Date;
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
public class TitleController {
	
	@Autowired
	private TitleService titleService;
	
	@RequestMapping(method=RequestMethod.GET, value="employees/{emp_no}/titles")
	public @ResponseBody Title getTitlesByEmp_no(@PathVariable("emp_no") @Valid String emp_no) {
		Integer empNo = Integer.parseInt(emp_no);
		return titleService.getTitlesByEmpNo(empNo);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="title/{title}")
	public @ResponseBody List<Title> getTitlesByTitle(@PathVariable("title") String title) {
		return titleService.getTitles(title);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="title/{from_date}")
	public @ResponseBody List<Title> getTitlesByFromDate(@PathVariable("from_date") String fromDate) throws ParseException {
		Date sqlDate = titleService.str2SDate(fromDate);
		return titleService.getTitlesByFromDate(sqlDate);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="employees/{emp_no}/titles")
	public void addTitle(@RequestBody Title title, @PathVariable("emp_no") String empNo) {
		Integer empNoInteger = Integer.parseInt(empNo);
		Employee employee = new Employee(empNoInteger, null, null, null, null, null);
		EmbeddedKey embeddedKey = new EmbeddedKey(employee, null, null);
		title.setEmbeddedKey(embeddedKey);
		titleService.addTitle(title);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="employees/{emp_no}/titles")
	public void updateTitle(@RequestBody Title title, @PathVariable("emp_no") String empNo) {
		Integer _empNo = Integer.parseInt(empNo);
		Employee employee = new Employee(_empNo, null, null, null, null, null);
		title.setEmbeddedKey(new EmbeddedKey(employee, null, null));
		titleService.updateTitle(title);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="employees/{emp_no}/titles")
	public void deleteTitleByEmpNo(@PathVariable("emp_no") String empNo) {
		Integer intEmpNo = Integer.parseInt(empNo);
		titleService.deleteTitleByEmpNo(intEmpNo);
	}
	

}
