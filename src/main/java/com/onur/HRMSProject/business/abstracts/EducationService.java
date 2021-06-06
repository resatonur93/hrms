package com.onur.HRMSProject.business.abstracts;

import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.dtos.EducationDto;

import java.util.List;

public interface EducationService {
    Result add(EducationDto educationDto);

    DataResult<List<EducationDto>> getAll();

    DataResult<List<EducationDto>> findAllByResumeIdOrderByEndedDateDesc(int id);
}
