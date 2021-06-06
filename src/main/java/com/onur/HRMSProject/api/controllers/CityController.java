package com.onur.HRMSProject.api.controllers;

import com.onur.HRMSProject.business.abstracts.CityService;
import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        super();
        this.cityService = cityService;
    }

    @GetMapping("/getall")
    public DataResult<List<City>> getAll(){
        return cityService.getAll();
    }

}