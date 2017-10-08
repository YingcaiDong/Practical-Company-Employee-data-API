package com.Employee.DataManagement.departmentEmployees;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptEmpService {

	@Autowired
	private DeptEmpRepository deptEmpRepository;
	
	public DepartmentEmployee getDepartmentEmployeesByEmpNo(Integer empNo) {
		return deptEmpRepository.findByDeeKeyEmployeeEmpNo(empNo);
	}
	
	public List<DepartmentEmployee> getDepartmentEmployeesByDeptNo(String deptNo) {
		List<DepartmentEmployee> departmentEmployees = new ArrayList<>();
		deptEmpRepository.findByDeeKeyDepartmentDeptNo(deptNo).forEach(departmentEmployees::add);
		return departmentEmployees;
	}
	
	public List<DepartmentEmployee> getDepartmentEmployeesByFromDate(Date fromDate) {
		List<DepartmentEmployee> departmentEmployees = new ArrayList<>();
		deptEmpRepository.findByFromDate(fromDate).forEach(departmentEmployees::add);
		return departmentEmployees;
	}
	
	public List<DepartmentEmployee> getDepartmentEmployeesByToDate(Date toDate) {
		List<DepartmentEmployee> departmentEmployees = new ArrayList<>();
		deptEmpRepository.findByToDate(toDate).forEach(departmentEmployees::add);
		return departmentEmployees;
	}
	
	public void addDepartmentEmployees(DepartmentEmployee departmentEmployee) {
		deptEmpRepository.save(departmentEmployee);
	}
	
	public void updateDepartmentEmployees(DepartmentEmployee departmentEmployee) {
		deptEmpRepository.save(departmentEmployee);
	}
	
	public void deleteAllEmployeesUnderDepartment(String deptNo) {
		deptEmpRepository.deleteByDeeKeyDepartmentDeptNo(deptNo);
	}
	
	public void deleteEmployeeByEmpNo(Integer empNo) {
		deptEmpRepository.deleteByDeeKeyEmployeeEmpNo(empNo);
	}
	
	// string date format should be like 1992-02-13 (yyyy-MM-dd)
	public Date str2SDate(String strDate) throws ParseException {
		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sDateFormat.parse(strDate);
		return new java.sql.Date(date.getTime());
	}
}
