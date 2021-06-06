package com.onur.HRMSProject.api.controllers;

import com.onur.HRMSProject.business.abstracts.ConfirmEmployerService;
import com.onur.HRMSProject.core.results.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validEmployer")
public class ConfirmEmployerController {

    private ConfirmEmployerService confirmEmployerService;

    public ConfirmEmployerController(ConfirmEmployerService confirmEmployerService) {
        super();
        this.confirmEmployerService = confirmEmployerService;
    }


    @PutMapping("/{companyName}")
    public Result update(@PathVariable("companyName") String companyName) {

        return confirmEmployerService.confirmUser(companyName);
    }
}