package com.onur.HRMSProject.api.controllers;

import com.onur.HRMSProject.business.abstracts.LanguageService;
import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.dtos.LanguageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("api/language")
public class LanguageController {

    private LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        super();
        this.languageService = languageService;
    }

    @GetMapping("/getall")
    public DataResult<List<LanguageDto>> getAll(){
        return this.languageService.getAll();
    }


    @PostMapping("/add")
    public Result add(@Valid @RequestBody LanguageDto languageDto) {
        return this.languageService.add(languageDto);
    }

}