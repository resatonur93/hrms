package com.onur.HRMSProject.business.abstracts;

import java.util.List;

import com.onur.HRMSProject.entities.concretes.SystemUser;

public interface SystemUserService {
List<SystemUser> getAll();
}
