package com.onur.HRMSProject.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

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
