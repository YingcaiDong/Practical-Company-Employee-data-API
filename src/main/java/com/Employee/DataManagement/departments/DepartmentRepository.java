package com.Employee.DataManagement.departments;

import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, String>{
	
	public Department findByDeptName(String deptName);
}
