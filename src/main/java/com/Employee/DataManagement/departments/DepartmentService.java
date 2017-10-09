package com.Employee.DataManagement.departments;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public List<Department> getAllDepartments() {
		List<Department> arrDepartments = new ArrayList<Department>();
		departmentRepository.findAll().forEach(arrDepartments::add);
		return arrDepartments;
	}
	
	public Department getDepartmentByDeptNo(String deptNo) {
		return departmentRepository.findOne(deptNo);
	}
	
	public Department getDepartmentByDeptName(String deptName	) {
		return departmentRepository.findByDeptName(deptName);
	}
	
	public void addDepartment(Department department) {
		departmentRepository.save(department);
	}
	
	public void updateDepartment(Department department) {
		departmentRepository.save(department);
	}
	
	public void deleteDepartment(String deptNo) {
		departmentRepository.delete(deptNo);
	}
}
