package com.Employee.DataManagement.departmentManagers;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptMagrService {
	@Autowired
	private DeptMagrRepository deptMagrRepository;
	
	public List<DepartmentManager> getDepartmentManagersByDeptNo(String deptNo) {
		return deptMagrRepository.findByDeptMangrKeyDepartmentDeptNo(deptNo);
	}
	
	public void addDepartmentManager(DepartmentManager departmentManager) {
		deptMagrRepository.save(departmentManager);
	}
	
	public void updateDepartmentManager(DepartmentManager departmentManager) {
		deptMagrRepository.save(departmentManager);
	}
	
	public void deleteDepartmentManagerByDeptNo(String deptNo) {
		deptMagrRepository.deleteByDeptMangrKeyDepartmentDeptNo(deptNo);
	}
	
	public void deleteDepartmentManagerByEmpNo(Integer empNo) {
		deptMagrRepository.deleteByDeptMangrKeyEmployeeEmpNo(empNo);
	}
	
	public void deleteDepartmentManagerByEmpDept(Integer empNo, String deptNo) {
		deptMagrRepository.deleteByDeptMangrKey_Employee_EmpNoAndDeptMangrKey_Department_DeptNo(empNo, deptNo);
	}
	
	// string date format should be like 1992-02-13 (yyyy-MM-dd)
	public Date str2SDate(String strDate) throws ParseException {
		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sDateFormat.parse(strDate);
		return new java.sql.Date(date.getTime());
	}
}
