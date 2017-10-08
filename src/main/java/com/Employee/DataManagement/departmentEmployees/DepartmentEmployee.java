package com.Employee.DataManagement.departmentEmployees;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="dept_emp")
public class DepartmentEmployee {
	@EmbeddedId
	private DeptEmpEmbdKey deeKey;
}
