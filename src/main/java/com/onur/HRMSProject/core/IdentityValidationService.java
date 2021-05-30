package com.onur.HRMSProject.core;

import com.onur.HRMSProject.core.results.Result;

public interface IdentityValidationService {
   Result validate(String tckn, String firstName, String lastName, int yearOfDate);
}
