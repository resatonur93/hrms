package com.onur.HRMSProject.business.concretes;

import com.onur.HRMSProject.business.abstracts.FieldService;
import com.onur.HRMSProject.business.abstracts.JobPositionService;
import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobPositionManager implements JobPositionService {

	private FieldService<JobPosition> controllerService;


	@Autowired
	public JobPositionManager(FieldService<JobPosition> controllerService) {
		super();
		this.controllerService = controllerService;
	}


	@Override
	public DataResult<List<JobPosition>> getAll() {
		return controllerService.getAll();
	}


	@Override
	public Result add(JobPosition newJobPositions) {
		return controllerService.verifyData(newJobPositions);
	}

}
