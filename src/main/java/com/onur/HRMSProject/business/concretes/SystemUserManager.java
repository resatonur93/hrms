package com.onur.HRMSProject.business.concretes;

import java.util.List;

import com.onur.HRMSProject.business.abstracts.SystemUserService;
import org.springframework.stereotype.Service;

import com.onur.HRMSProject.dataAcces.abstracts.SystemUserDao;
import com.onur.HRMSProject.entities.concretes.SystemUser;

@Service
public class SystemUserManager implements SystemUserService {
private SystemUserDao systemUserDao;

	public SystemUserManager(SystemUserDao systemUserDao) {
	super();
	this.systemUserDao = systemUserDao;
}

	@Override
	public List<SystemUser> getAll() {
		// TODO Auto-generated method stub
		return this.systemUserDao.findAll();
	}

}
