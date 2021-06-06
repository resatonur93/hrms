package com.onur.HRMSProject.business.abstracts;

import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.dtos.JobExperienceDto;

import java.util.List;

public interface JobExperienceService {
    Result add(JobExperienceDto jobExpeerienceDto);
    DataResult<List<JobExperienceDto>> getAll();
    DataResult<List<JobExperienceDto>> findAllByResumeIdOrderByEndedDateDesc(int id);
}
