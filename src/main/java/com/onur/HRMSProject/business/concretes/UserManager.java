package com.onur.HRMSProject.business.concretes;

import java.util.List;

import com.onur.HRMSProject.core.helpers.EmailService;
import com.onur.HRMSProject.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.ErrorResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.core.results.SuccessDataResult;
import com.onur.HRMSProject.core.results.SuccessResult;
import com.onur.HRMSProject.dataAcces.abstracts.UserDao;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
	private EmailService emailService;
	
	@Autowired
	public UserManager(UserDao userDao, EmailService emailService) {
		super();
		this.userDao = userDao;
		this.emailService=emailService;
	}


	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(userDao.findAll());
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		
		return new SuccessDataResult<User>(userDao.findByEmail(email));
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		this.emailService.send(user.getEmail(),
				"Doğrulama Linki", 
				"HRMS Sistemine hoşgeldiniz. "
				+ "Aşşağıdaki linke tıklayarak üyeliğinizi doğrulayabilirsiniz \n "
				+ "www.localhost:8080/api/users/verify?email=" + user.getEmail() + "&verifycode=" + user.getEmailVerifyCode());
		return new SuccessResult();
	}

	@Override
	public Result verifyUser(String email, String emailVerifyCode) {
		
		User user = userDao.findByEmailAndEmailVerifyCode(email, emailVerifyCode);
		if (user== null) 
			return new ErrorResult("Doğrulama başarısız, lütfen bilgilerinizi tekrar giriniz!");

		user.setEmailVerified(true);
		userDao.save(user);
		return new SuccessResult ("Kullanıcı e-postası başarıyla doğrulandı.");
			

		
	}

}
