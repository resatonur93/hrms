package com.onur.HRMSProject.api.controllers;

import com.onur.HRMSProject.business.abstracts.CandidateService;
import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {


    private CandidateService candidatesService;


    @Autowired
    public CandidateController(CandidateService candidatesService) {
        super();
        this.candidatesService = candidatesService;

    }

    @GetMapping("/getall")
    public DataResult<List<Candidate>> getAll(){
        return this.candidatesService.getAll();
    }

    @PostMapping("/add")
    public Result newCandidate(@Valid @RequestBody Candidate newCandidate){
        return candidatesService.add(newCandidate);
    }


}