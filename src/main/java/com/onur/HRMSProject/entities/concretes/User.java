package com.onur.HRMSProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table (name="users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="email",unique=true)
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email_verified")
	private boolean emailVerified;
	
	@Column(name="email_verify_code",nullable=false)
	private String emailVerifyCode;

	public User(String email, String password, boolean emailVerified, String emailVerifyCode) {
		super();
		this.email = email;
		this.password = password;
		this.emailVerified = emailVerified;
		this.emailVerifyCode = emailVerifyCode;
	}
	
	
	
	
	
	
	
}
