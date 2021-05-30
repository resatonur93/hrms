package com.onur.HRMSProject.business.abstracts;

import java.util.List;

import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.User;

public interface UserService {
	DataResult<List<User>> getAll();
	DataResult<User> getByEmail(String email);
	Result add (User user);
	Result verifyUser(String email, String verificationCode);
}
