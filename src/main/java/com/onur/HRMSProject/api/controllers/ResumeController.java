package com.onur.HRMSProject.api.controllers;

import com.onur.HRMSProject.business.abstracts.ResumeService;
import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.dtos.ResumeAddDto;
import com.onur.HRMSProject.entities.concretes.dtos.ResumeGetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value= "api/resumes")
public class ResumeController {

    private ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService) {
        super();
        this.resumeService = resumeService;
    }

    @GetMapping("/getall")
    public DataResult<List<ResumeGetDto>> getAll(){
        return this.resumeService.getAll();
    }

    @GetMapping("/getByCandidateId")
    public DataResult<List<ResumeGetDto>> findAllByCandidateId(int id){
        return this.resumeService.findAllByCandidateId(id);
    }


    @PostMapping(value="/add")
    public Result add(@Valid @RequestBody ResumeAddDto resumeDto) {
        return this.resumeService.add(resumeDto);

    }


    @PutMapping("/uploadImage")
    public Result saveImage(@RequestBody MultipartFile file,@RequestParam int resumeId) {
        return this.resumeService.saveImage(file, resumeId);

    }

}