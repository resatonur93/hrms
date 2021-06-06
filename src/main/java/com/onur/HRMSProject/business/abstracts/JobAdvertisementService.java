package com.onur.HRMSProject.business.abstracts;

import java.util.List;

import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.JobPosting;
import com.onur.HRMSProject.entities.concretes.dtos.JobPostingDto;


public interface JobAdvertisementService {
    DataResult<List<JobPosting>> findByIsActiveTrue();
    DataResult<List<JobPosting>> findByIsActiveTrueOrderByCreateDate();
    DataResult<List<JobPosting>> findByEmployer_EmployerId(int employerId);
    Result addNew(JobPostingDto jobAdvertisement);
    Result changeStatus(int advertisementId, int employerId);
}
