package com.Employee.DataManagement.departmentManagers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface DeptMagrRepository extends CrudRepository<DepartmentManager, DeptMangrKey>{
	public List<DepartmentManager> findByDeptMangrKeyDepartmentDeptNo(String deptNo);
	
	public void deleteByDeptMangrKeyDepartmentDeptNo(String deptNo);
	public void deleteByDeptMangrKeyEmployeeEmpNo(Integer empNo);
	
	public void deleteByDeptMangrKey_Employee_EmpNoAndDeptMangrKey_Department_DeptNo(Integer empNo, String deptNo);
}
