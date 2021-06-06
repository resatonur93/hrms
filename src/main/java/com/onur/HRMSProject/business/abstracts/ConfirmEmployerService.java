package com.onur.HRMSProject.business.abstracts;

import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.Employer;

public interface ConfirmEmployerService {
    void createConfirmEmployer(Employer employer);
    Result confirmUser(String companyName);
}
