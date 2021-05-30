package com.onur.HRMSProject.core;


import org.springframework.stereotype.Service;

import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.core.results.SuccessResult;

@Service
public class MernisServiceAdapter implements IdentityValidationService{

	@Override
	public Result validate(String tckn, String firstName, String lastName, int yearOfDate){
		return new SuccessResult("TCKN doğrulaması başarılı.");
	}

	

}
