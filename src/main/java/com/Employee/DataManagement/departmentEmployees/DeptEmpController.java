package com.Employee.DataManagement.departmentEmployees;


import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.DataManagement.departments.Department;
import com.Employee.DataManagement.employees.Employee;

@RestController
@RequestMapping("department_employee")
public class DeptEmpController {
	@Autowired
	private DeptEmpService deptEmpService;
	
	@RequestMapping("/find/empno_{emp_no}")
	public @ResponseBody DepartmentEmployee findDepartmentEmployeesByEmpNo(@PathVariable("emp_no") String empNo) {
		Integer empNoInteger = Integer.parseInt(empNo);
		return deptEmpService.getDepartmentEmployeesByEmpNo(empNoInteger);
	}
	
	@RequestMapping("/find/deptno_{dept_no}")
	public @ResponseBody List<DepartmentEmployee> findDepartmentEmployeesByDeptNo(@PathVariable("dept_no")  String deptNo) {
		return deptEmpService.getDepartmentEmployeesByDeptNo(deptNo);
	}
	
	@RequestMapping("/find/fdate_{from_date}")
	public @ResponseBody List<DepartmentEmployee> findDepartmentEmployeesByFromDate(@PathVariable("from_date") String fromDate) throws ParseException {
		Date sqlDate = deptEmpService.str2SDate(fromDate);
		return deptEmpService.getDepartmentEmployeesByFromDate(sqlDate);
	}
	
	@RequestMapping("/find/tdate_{to_date}")
	public @ResponseBody List<DepartmentEmployee> finDepartmentEmployeesByToDate(@PathVariable("to_date") String toDate) throws ParseException {
		Date sqlDate = deptEmpService.str2SDate(toDate);
		return deptEmpService.getDepartmentEmployeesByToDate(sqlDate);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/add/empno_{emp_no}_deptno_{dept_no}")
	public void addDepartmentEmployee(@RequestBody DepartmentEmployee departmentEmployee, @PathVariable("emp_no") String empNo, @PathVariable("dept_no") String deptNo) {
		Integer empNoInteger = Integer.parseInt(empNo);
		Department department = new Department(deptNo, null);
		Employee employee = new Employee(empNoInteger, null, null, null, null, null);
		DeptEmpEmbdKey deptEmpEmbdKey = new DeptEmpEmbdKey(department, employee);
		departmentEmployee.setDeeKey(deptEmpEmbdKey);
		deptEmpService.addDepartmentEmployees(departmentEmployee);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/update/empno_{emp_no}_deptno_{dept_no}")
	public void updateDepartmentEmployee(@RequestBody DepartmentEmployee departmentEmployee, @PathVariable("emp_no") String empNo, @PathVariable("dept_no") String deptNo) {
		Integer empNoInteger = Integer.parseInt(empNo);
		Department department = new Department(deptNo, null);
		Employee employee = new Employee(empNoInteger, null, null, null, null, null);
		DeptEmpEmbdKey deptEmpEmbdKey = new DeptEmpEmbdKey(department, employee);
		departmentEmployee.setDeeKey(deptEmpEmbdKey);
		deptEmpService.updateDepartmentEmployees(departmentEmployee);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/deptno_{dept_no}")
	public void deleteAllEmployeesUnderDepartment(@PathVariable("dept_no") String deptNo) {
		deptEmpService.deleteAllEmployeesUnderDepartment(deptNo);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/empno_{emp_no}")
	public void deletEmployeeByEmpNo(@PathVariable("emp_no") String empNo) {
		Integer empNoInteger = Integer.parseInt(empNo);
		deptEmpService.deleteEmployeeByEmpNo(empNoInteger);
	}
	
}
