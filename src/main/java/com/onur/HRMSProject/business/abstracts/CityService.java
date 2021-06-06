package com.onur.HRMSProject.business.abstracts;

import java.util.List;

import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.entities.concretes.City;


public interface CityService {
       DataResult<List<City>> getAll();
}
