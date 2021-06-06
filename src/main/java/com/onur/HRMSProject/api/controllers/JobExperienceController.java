package com.onur.HRMSProject.api.controllers;

import com.onur.HRMSProject.business.abstracts.JobExperienceService;
import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.dtos.JobExperienceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RestController
@RequestMapping("api/jobExperience")
public class JobExperienceController {

    private JobExperienceService jobExperienceService;

    @Autowired
    public JobExperienceController(JobExperienceService jobExperienceService) {
        super();
        this.jobExperienceService = jobExperienceService;
    }


    @GetMapping("/getall")
    public DataResult<List<JobExperienceDto>> getAll(){
        return this.jobExperienceService.getAll();
    }

    @GetMapping("/getOrderByDate")
    public DataResult<List<JobExperienceDto>> findAllByResumeIdOrderByEndedDateDesc(int id){
        return this.jobExperienceService.findAllByResumeIdOrderByEndedDateDesc(id);
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody JobExperienceDto jobExperienceDto) {
        return this.jobExperienceService.add(jobExperienceDto);
    }

}