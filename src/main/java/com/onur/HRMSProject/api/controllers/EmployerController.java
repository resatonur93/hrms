package com.onur.HRMSProject.api.controllers;

import com.onur.HRMSProject.business.abstracts.EmployerService;
import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.Employer;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/employers")
public class EmployerController {

	private EmployerService employerService;

	public EmployerController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}

	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}

	@PostMapping("/add")
	public Result newEmployer(@Valid @RequestBody Employer employer) {
		return employerService.add(employer);
	}
}