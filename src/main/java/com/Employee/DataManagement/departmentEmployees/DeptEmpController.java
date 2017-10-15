package com.Employee.DataManagement.departmentEmployees;


import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.DataManagement.departments.Department;
import com.Employee.DataManagement.employees.Employee;

@CrossOrigin
@RestController
@RequestMapping("department_employee")
public class DeptEmpController {
	@Autowired
	private DeptEmpService deptEmpService;
	
	@RequestMapping(method=RequestMethod.GET, value="/find/empno_{emp_no}")
	public @ResponseBody List<DepartmentEmployee> findDepartmentEmployeesByEmpNo(@PathVariable("emp_no") String empNo) {
		Integer empNoInteger = Integer.parseInt(empNo);
		return deptEmpService.getDepartmentEmployeesByEmpNo(empNoInteger);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/find/deptno_{dept_no}")
	public @ResponseBody List<DepartmentEmployee> findDepartmentEmployeesByDeptNo(@PathVariable("dept_no")  String deptNo) {
		return deptEmpService.getDepartmentEmployeesByDeptNo(deptNo);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/find/fdate_{from_date}")
	public @ResponseBody List<DepartmentEmployee> findDepartmentEmployeesByFromDate(@PathVariable("from_date") String fromDate) throws ParseException {
		Date sqlDate = deptEmpService.str2SDate(fromDate);
		return deptEmpService.getDepartmentEmployeesByFromDate(sqlDate);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/find/tdate_{to_date}")
	public @ResponseBody List<DepartmentEmployee> finDepartmentEmployeesByToDate(@PathVariable("to_date") String toDate) throws ParseException {
		Date sqlDate = deptEmpService.str2SDate(toDate);
		return deptEmpService.getDepartmentEmployeesByToDate(sqlDate);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/add")
	public void addDepartmentEmployee(@RequestBody DepartmentEmployee departmentEmployee) {
		Department department = new Department(departmentEmployee.getDeeKey().getDepartment().getDeptNo(), null);
		Employee employee = new Employee(departmentEmployee.getDeeKey().getEmployee().getEmp_no(), null, null, null, null, null);
		DeptEmpEmbdKey deptEmpEmbdKey = new DeptEmpEmbdKey(department, employee);
		departmentEmployee.setDeeKey(deptEmpEmbdKey);
		deptEmpService.addDepartmentEmployees(departmentEmployee);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/update", params={"emp_no", "dept_no"})
	public void updateDepartmentEmployee(
			@RequestBody DepartmentEmployee departmentEmployee,
			@RequestParam("emp_no") String empNo,
			@RequestParam("dept_no") String deptNo) {
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
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete", params={"dept_no", "emp_no"})
	public void deleteEmployeeByDeptEmp(
			@RequestParam("dept_no") String deptNo,
			@RequestParam("emp_no") String empNo) {
		Integer empNoInteger = Integer.parseInt(empNo);
		deptEmpService.deleteEmployeeByDeptEmp(deptNo, empNoInteger);
	}
}
