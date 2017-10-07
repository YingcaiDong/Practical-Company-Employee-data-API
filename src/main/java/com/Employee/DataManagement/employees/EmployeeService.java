package com.Employee.DataManagement.employees;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getRangeEmployees(Integer _from, Integer _end) {
		// TODO Auto-generated method stub
		List<Employee> employees = new ArrayList<>();
		for(Integer id = _from; id < _end+1; id++) {
			employees.add(employeeRepository.findOne(id));
		}
		return employees;
	}

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		employeeRepository.findAll().forEach(employees::add);
		return employees;
	}

	public Employee getEmployee(Integer intId) {
		return employeeRepository.findOne(intId);
	}

	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	public void updateEmployee(Employee employee, Integer intId) {
		employeeRepository.save(employee);
	}

	public void deleteEmployee(Integer intId) {
		employeeRepository.delete(intId);
	}

}
