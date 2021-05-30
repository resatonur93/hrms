package com.onur.HRMSProject.business.abstracts;

import java.util.List;

import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.JobPosition;


public interface JobPositionService {
	List<JobPosition> getAll();
    JobPosition getByPositionName(String positionName);
    Result addNew(JobPosition jobPosition);
    DataResult<JobPosition> getById(int id);

}
