package com.onur.HRMSProject.business.abstracts;

import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.User;

public interface VerifyCodeService {
    String createVerifyCode(User user);
    void sendMail(String mail);
    Result verifyUser(String code);
}
