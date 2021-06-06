package com.onur.HRMSProject.business.abstracts;

import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.Education;

import java.util.List;

public interface EducationService {
    Result add(Education education);
    DataResult<List<Education>> getAll();
}
