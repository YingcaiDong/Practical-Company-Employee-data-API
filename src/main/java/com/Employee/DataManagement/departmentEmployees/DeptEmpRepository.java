package com.Employee.DataManagement.departmentEmployees;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface DeptEmpRepository extends CrudRepository<DepartmentEmployee, String> {
	public List<DepartmentEmployee> findByDeeKeyEmployeeEmpNo(Integer empNo);
	public List<DepartmentEmployee> findByDeeKeyDepartmentDeptNo(String deptNo);
	public List<DepartmentEmployee> findByFromDate(Date fromDate);
	public List<DepartmentEmployee> findByToDate(Date toDate);
	
	public void deleteByDeeKeyEmployeeEmpNo(Integer empNo);
	public void deleteByDeeKeyDepartmentDeptNo(String deptNo);
	
	public void deleteByDeeKey_Department_DeptNoAndDeeKey_Employee_EmpNo(String deptNo, Integer empNo);
}