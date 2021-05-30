package com.onur.HRMSProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onur.HRMSProject.business.abstracts.SystemUserService;
import com.onur.HRMSProject.entities.concretes.SystemUser;

@RestController
@RequestMapping("/api/systemusers")
public class SystemUsersController {
	private SystemUserService systemUserService;

	@Autowired
	public SystemUsersController(SystemUserService systemUserService) {
		super();
		this.systemUserService = systemUserService;
	}

	@GetMapping ("getall")
	public List<SystemUser> getAll() {
		return systemUserService.getAll();

	}

}
