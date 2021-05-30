package com.onur.HRMSProject.core.helpers;

import com.onur.HRMSProject.core.results.Result;
import org.springframework.stereotype.Service;

import com.onur.HRMSProject.core.results.SuccessResult;



@Service
public class EmailManager implements EmailService{

	@Override
	public Result send(String to, String title, String message) {
		return new SuccessResult("E-posta başarıyla gönderildi.");
	}

}
