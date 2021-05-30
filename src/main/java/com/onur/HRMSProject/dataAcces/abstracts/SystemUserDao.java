package com.onur.HRMSProject.dataAcces.abstracts;

import com.onur.HRMSProject.entities.concretes.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemUserDao extends JpaRepository<SystemUser, Integer>{

}
