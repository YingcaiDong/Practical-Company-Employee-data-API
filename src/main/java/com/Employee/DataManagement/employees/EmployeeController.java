package com.Employee.DataManagement.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/range/{from}to{end}")
	public @ResponseBody List<Employee> getRangeEmployees(@PathVariable("from") String from, @PathVariable("end") String end) {
		Integer _from = Integer.parseInt(from);
		Integer _end = Integer.parseInt(end);
		return employeeService.getRangeEmployees(_from, _end);
	}
	
	@RequestMapping("/id_{id}")
	public @ResponseBody Employee getEmployee(@PathVariable String id) {
		Integer intId = Integer.parseInt(id);
		return employeeService.getEmployee(intId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="")
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/id_{id}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable String id) {
		Integer intId = Integer.parseInt(id);
		employeeService.updateEmployee(employee, intId);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/id_{id}")
	public void deleteEmployee(@PathVariable String id) {
		Integer intId = Integer.parseInt(id);
		employeeService.deleteEmployee(intId);
	}

}
