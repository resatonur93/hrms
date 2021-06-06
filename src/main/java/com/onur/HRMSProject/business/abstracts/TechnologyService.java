package com.onur.HRMSProject.business.abstracts;

import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.Technology;

import java.util.List;

public interface TechnologyService {
    DataResult<List<Technology>> getAll();
    Result add(Technology technology);
}
