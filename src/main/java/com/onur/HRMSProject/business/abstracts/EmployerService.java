package com.onur.HRMSProject.business.abstracts;

import java.util.List;

import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.Employer;
import com.onur.HRMSProject.entities.concretes.dtos.EmployerForRegisterDto;

public interface EmployerService {
	DataResult<List<Employer>> getAll();
	Result register(EmployerForRegisterDto employer);
	DataResult<Employer> getById(int id);

}
