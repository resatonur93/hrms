package com.onur.HRMSProject.api.controllers;

import com.onur.HRMSProject.business.abstracts.JobPostingService;
import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.dtos.JobPostingAddDto;
import com.onur.HRMSProject.entities.concretes.dtos.JobPostingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/jobPostings")
public class JobPostingController {

	private JobPostingService jobPostingService;

	@Autowired
	public JobPostingController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}


	@GetMapping("/getActive")
	DataResult<List<JobPostingDto>> findByIsActive(){
		return this.jobPostingService.findByIsActive();
	}


	@PostMapping("/add")
	Result add(@Valid @RequestBody JobPostingAddDto jobPostingAddDto) {
		return this.jobPostingService.add(jobPostingAddDto);
	}


	@GetMapping("/getActive/OrderByEndDate")
	DataResult<List<JobPostingDto>> findByIsActiveOrderByClosedDate(){
		return this.jobPostingService.findByIsActiveOrderByClosedDate();
	}

	@GetMapping("/get/CompanyName")
	DataResult<List<JobPostingDto>> findByIsActiveAndEmployer_CompanyName(String companyName){
		return this.jobPostingService.findByIsActiveAndEmployer_CompanyName(companyName);

	}
}