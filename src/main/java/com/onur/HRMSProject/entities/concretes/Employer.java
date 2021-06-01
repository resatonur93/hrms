package com.onur.HRMSProject.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@PrimaryKeyJoinColumn(name="user_id")
@Entity
@Data
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends User {
	

	@NotBlank(message = "Şirket ismi alanı boş bırakılamaz.")
	@Column(name="company_name")
	private String companyName;

	@NotBlank(message = "Web sitesi alanı boş bırakılamaz.")
	@Column(name="web_address")
	private String webAddress;

	@NotBlank(message = "Telefın numarası alanı boş bırakılamaz.")
	@Column(name="phone_number")
	private String phoneNumber;

	@JsonIgnore
	@Column(name="user_confirm")
	private boolean userConfirm;
	


}
