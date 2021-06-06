package com.onur.HRMSProject.api.controllers;

import com.onur.HRMSProject.business.abstracts.EducationService;
import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.dtos.EducationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/education")
public class EducationController {

    private EducationService educationService;


    @Autowired
    public EducationController(EducationService educationService) {
        super();
        this.educationService = educationService;

    }

    @GetMapping("/getall")
    public DataResult<List<EducationDto>> getAll(){
        return this.educationService.getAll();
    }

    @GetMapping("/getOrderByDate")
    public DataResult<List<EducationDto>> findAllByResumeIdOrderByEndedDateDesc(int id){
        return this.educationService.findAllByResumeIdOrderByEndedDateDesc(id);
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody EducationDto educationDto) {
        return this.educationService.add(educationDto);
    }



}
