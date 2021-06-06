package com.onur.HRMSProject.api.controllers;

import com.onur.HRMSProject.business.abstracts.GraduateService;
import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.Graduate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RestController
@RequestMapping("/api/graduate")
public class GraduateController {

    private GraduateService graduateService;

    @Autowired
    public GraduateController(GraduateService graduateService) {
        super();
        this.graduateService = graduateService;
    }


    @GetMapping("/getall")
    public DataResult<List<Graduate>> getAll(){
        return this.graduateService.getAll();
    }


    @PostMapping("/add")
    public Result add(@Valid @RequestBody Graduate graduate) {
        return this.graduateService.add(graduate);
    }

}