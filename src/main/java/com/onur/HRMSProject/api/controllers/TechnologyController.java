package com.onur.HRMSProject.api.controllers;

import com.onur.HRMSProject.business.abstracts.TechnologyService;
import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.dtos.TechnologyDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("api/technology")
public class TechnologyController {

    private TechnologyService technologyService;

    public TechnologyController(TechnologyService technologyService) {
        super();
        this.technologyService = technologyService;
    }

    @GetMapping("/getall")
    public DataResult<List<TechnologyDto>> getAll(){
        return this.technologyService.getAll();
    }


    @PostMapping("/add")
    public Result add(@Valid @RequestBody TechnologyDto technologyDto) {
        return this.technologyService.add(technologyDto);
    }

}