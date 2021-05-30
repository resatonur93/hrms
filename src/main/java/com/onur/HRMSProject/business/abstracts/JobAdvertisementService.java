package com.onur.HRMSProject.business.abstracts;

import java.util.List;

import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.JobAdvertisement;
import com.onur.HRMSProject.entities.concretes.dtos.JobAdvertisementForAddDto;


public interface JobAdvertisementService {
    DataResult<List<JobAdvertisement>> findByIsActiveTrue();
    DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByCreateDate();
    DataResult<List<JobAdvertisement>> findByEmployer_EmployerId(int employerId);
    Result addNew(JobAdvertisementForAddDto jobAdvertisement);
    Result changeStatus(int advertisementId, int employerId);
}
