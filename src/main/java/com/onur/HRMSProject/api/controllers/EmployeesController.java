package com.onur.HRMSProject.api.controllers;

import java.util.List;

import com.onur.HRMSProject.dataAcces.abstracts.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onur.HRMSProject.business.abstracts.EmployeeService;
import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.Employee;
import com.onur.HRMSProject.entities.concretes.dtos.EmployeeForRegisterDto;


@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employee>> getAll(){
		return employeeService.getAll();
		
	}
	
	@PostMapping("/register")
	public Result add(@RequestBody EmployeeForRegisterDto employee) {
		return this.employeeService.register(employee);
	}
	
}
