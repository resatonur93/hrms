package com.onur.HRMSProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onur.HRMSProject.business.abstracts.JobPositionService;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.JobPosition;


@RestController
@RequestMapping ("/api/jobpositions")
public class JobPositionsController {

	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	

	@GetMapping("/getall")
	public List<JobPosition> getAll(){
		return this.jobPositionService.getAll();
	}
	
	@GetMapping("/getbyname")
	public JobPosition getByPositionName(String positionName){
		return this.jobPositionService.getByPositionName(positionName);
	}
	@PostMapping("add")
	public Result addNew(@RequestBody JobPosition jobPosition) {
		return this.jobPositionService.addNew(jobPosition);
	}
}
