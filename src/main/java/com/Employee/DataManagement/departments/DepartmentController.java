package com.Employee.DataManagement.departments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(method=RequestMethod.GET, value="/all")
	public @ResponseBody List<Department> getAllDepartents() {
		return departmentService.getAllDepartments();
	}

	@RequestMapping(method=RequestMethod.GET, value="/dept_no_{dept_no}")
	public @ResponseBody Department getDepartmentByDeptNo(@PathVariable("dept_no") String deptNo) {
		return departmentService.getDepartmentByDeptNo(deptNo);
	}

	@RequestMapping(method=RequestMethod.GET, value="/dept_name_{dept_name}")
	public @ResponseBody Department getDepartmentByDeptName(@PathVariable("dept_name") String deptName) {
		return departmentService.getDepartmentByDeptName(deptName);
	}

	@RequestMapping(method=RequestMethod.POST, value="")
	public void addDepartment(@RequestBody Department department) {
		departmentService.addDepartment(department);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/id_{dept_no}")
	public void updateDepartment(@RequestBody Department department, @PathVariable("dept_no") String deptNo) {
		departmentService.updateDepartment(department);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/id_{dept_no}")
	public void deleteDepartment(@PathVariable("dept_no") String deptNo) {
		departmentService.deleteDepartment(deptNo);
	}
}
