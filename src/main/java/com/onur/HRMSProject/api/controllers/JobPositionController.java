package com.onur.HRMSProject.api.controllers;

import com.onur.HRMSProject.business.abstracts.JobPositionService;
import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RestController
@RequestMapping("/api/jobs")
public class JobPositionController {


    private JobPositionService jobPositionsService;


    @Autowired
    public JobPositionController(JobPositionService jobPositionsService) {
        super();
        this.jobPositionsService = jobPositionsService;
    }



    @GetMapping("/getall")
    public DataResult<List<JobPosition>> getAll(){
        return this.jobPositionsService.getAll();
    }


    @PostMapping("/add")
    public Result add(@Valid @RequestBody JobPosition newJobPositions) {
        return this.jobPositionsService.add(newJobPositions);
    }

}