package com.onur.HRMSProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
public class Employer {
	
	@Id
	@Column(name="user_id")
	private int userId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="verfied_by_system")
	private boolean verifiedBySystem;
	
	@Column(name="website")
	private String website;
	
	@OneToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name="user_id")
	private User user;
	
	public Employer(int userId, String companyName, String phone, boolean verifiedBySystem, String website) {
		this.userId = userId;
		this.companyName = companyName;
		this.phone = phone;
		this.verifiedBySystem = verifiedBySystem;
		this.website = website;
	}

}
