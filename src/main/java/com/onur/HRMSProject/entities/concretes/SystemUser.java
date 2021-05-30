package com.onur.HRMSProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table (name="system_users")
public class SystemUser {
	
	@Id
	@Column(name="user_id", nullable=false)
	private int userId;
	
	@Column(name="roles", nullable=false)
	private String roles;

}
