package com.Employee.DataManagement.departmentManagers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface DeptMagrRepository extends CrudRepository<DepartmentManager, DeptMangrKey>{
	public List<DepartmentManager> findByDeptMangrKeyDepartmentDeptNo(String deptNo);
	public List<DepartmentManager> findByDeptMangrKeyEmployeeEmpNo(Integer empNo);
	public List<DepartmentManager> findByDeptMangrKeyEmployeeEmpNoAndDeptMangrKeyDepartmentDeptNo(
			Integer empNo, String deptNo);
	
	public void deleteByDeptMangrKeyDepartmentDeptNo(String deptNo);
	public void deleteByDeptMangrKeyEmployeeEmpNo(Integer empNo);
	public void deleteByDeptMangrKeyEmployeeEmpNoAndDeptMangrKeyDepartmentDeptNo(
			Integer empNo, String deptNo);
}
