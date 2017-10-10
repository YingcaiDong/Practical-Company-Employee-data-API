package com.Employee.DataManagement.departmentManagers;

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
@RequestMapping("department_manager")
public class DeptMagrController {

	@Autowired
	private DeptMagrService deptMagrService;
	
	@RequestMapping(method=RequestMethod.GET, value="/find/dept_{dept_no}")
	public @ResponseBody List<DepartmentManager> getDepartmentManagersByDeptNo(
			@PathVariable("dept_no") String deptNo) {
		return deptMagrService.getDepartmentManagersByDeptNo(deptNo);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/find/emp_{emp_no}")
	public @ResponseBody List<DepartmentManager> getDepartmentManagersByEmpNo(
			@PathVariable("emp_no") String empNo) {
		Integer empNoInteger = Integer.parseInt(empNo);
		return deptMagrService.getDepartmentManagersByEmpNo(empNoInteger);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/find/dept_{dept_no}_emp_{emp_no}")
	public @ResponseBody List<DepartmentManager> getdepDepartmentManagersByEmpDept(
			@PathVariable("dept_no") String deptNo, 
			@PathVariable("emp_no") String empNo) {
		Integer empNoInteger = Integer.parseInt(empNo);
		return deptMagrService.getdepDepartmentManagersByEmpDept(empNoInteger, deptNo);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/add")
	public void addDepartmentManager(
			@RequestBody DepartmentManager departmentManager) {
		Integer empNo = departmentManager.getDeptMangrKey().getEmployee().getEmp_no();
		String deptNo = departmentManager.getDeptMangrKey().getDepartment().getDeptNo();
		DeptMangrKey deptMangrKey = new DeptMangrKey(
				new Department(deptNo, null),
				new Employee(empNo, null, null, null, null, null));
		departmentManager.setDeptMangrKey(deptMangrKey);
		deptMagrService.addDepartmentManager(departmentManager);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/update/emp_{emp_no}")
	public void updateDepartmentManagerByEmp(
			@RequestBody DepartmentManager departmentManager,
			@PathVariable("emp_no") String empNo) {
		Integer empNoInteger = Integer.parseInt(empNo);
		String deptNo = departmentManager.getDeptMangrKey().getDepartment().getDeptNo();
		DeptMangrKey deptMangrKey = new DeptMangrKey(
				new Department(deptNo, null),
				new Employee(empNoInteger, null, null, null, null, null));
		departmentManager.setDeptMangrKey(deptMangrKey);
		deptMagrService.addDepartmentManager(departmentManager);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/update/dept_{dept_no}")
	public void updateDepartmentManagerByDept(
			@RequestBody DepartmentManager departmentManager,
			@PathVariable("dept_no") String deptNo) {
		Integer empNo = departmentManager.getDeptMangrKey().getEmployee().getEmp_no();
		DeptMangrKey deptMangrKey = new DeptMangrKey(
				new Department(deptNo, null),
				new Employee(empNo, null, null, null, null, null));
		departmentManager.setDeptMangrKey(deptMangrKey);
		deptMagrService.addDepartmentManager(departmentManager);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/dept_{dept_no}")
	public void deleteDepartmentManagerByDeptNo(@PathVariable("dept_no") String deptNo) {
		deptMagrService.deleteDepartmentManagerByDeptNo(deptNo);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/emp_{emp_no}")
	public void deleteDepartmentManagerByEmpNo(@PathVariable("emp_no") String empNo) {
		Integer empNoInteger = Integer.parseInt(empNo);
		deptMagrService.deleteDepartmentManagerByEmpNo(empNoInteger);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/dept_{dept_no}_emp_{emp_no}")
	public void deleteDepartmentManagerByEmpDept(
			@PathVariable("dept_no") String deptNo, 
			@PathVariable("emp_no") String empNo) {
		Integer empNoInteger = Integer.parseInt(empNo);
		deptMagrService.deleteDepartmentManagerByEmpDept(empNoInteger, deptNo);
	}
}
