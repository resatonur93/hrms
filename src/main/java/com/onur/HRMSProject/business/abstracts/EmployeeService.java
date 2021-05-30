package com.onur.HRMSProject.business.abstracts;

import java.util.List;



import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.Employee;
import com.onur.HRMSProject.entities.concretes.dtos.EmployeeForRegisterDto;

public interface EmployeeService {
	DataResult<List<Employee>> getAll();
	Result register (EmployeeForRegisterDto employee);
	
}
