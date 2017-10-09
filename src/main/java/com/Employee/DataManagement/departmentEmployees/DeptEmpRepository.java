package com.Employee.DataManagement.departmentEmployees;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DeptEmpRepository extends CrudRepository<DepartmentEmployee, String> {
	public DepartmentEmployee findByDeeKeyEmployeeEmpNo(Integer empNo);
	public List<DepartmentEmployee> findByDeeKeyDepartmentDeptNo(String deptNo);
	public List<DepartmentEmployee> findByFromDate(Date fromDate);
	public List<DepartmentEmployee> findByToDate(Date toDate);
	
	public void deleteByDeeKeyEmployeeEmpNo(Integer empNo);
	public void deleteByDeeKeyDepartmentDeptNo(String deptNo);
}