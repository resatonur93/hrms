package com.onur.HRMSProject.core.helpers;

import com.onur.HRMSProject.core.results.Result;

public interface EmailService {
	Result send(String to, String title, String message);
}
