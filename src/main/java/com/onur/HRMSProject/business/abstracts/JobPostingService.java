package com.onur.HRMSProject.business.abstracts;

import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.JobPosition;
import com.onur.HRMSProject.entities.concretes.dtos.JobPostingAddDto;
import com.onur.HRMSProject.entities.concretes.dtos.JobPostingDto;

import javax.validation.Valid;
import java.util.List;



public interface JobPostingService {


    DataResult<List<JobPosition>> getAll();
    Result add(@Valid JobPostingAddDto newJobPositions);

    DataResult<List<JobPostingDto>> findByIsActive();

    DataResult<List<JobPostingDto>> findByIsActiveOrderByClosedDate();

    DataResult<List<JobPostingDto>> findByIsActiveAndEmployer_CompanyName(String companyName);
}