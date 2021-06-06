package com.onur.HRMSProject.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.Data;

@Entity
@Data
@Table (name="users")
@Inheritance(strategy = InheritanceType.JOINED)

public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Email(message="Lütfen geçerli mail adresi giriniz.")
	@NotBlank(message = "Mail alanını boş bırakmayınız.")
	@Column(name="mail")
	private String email;

	@NotBlank(message = "Şifre alanını boş bırakmayınız")
	@Size(min=6,max=16,message = "Şifre en az 6, en fazla 16 karakterden oluşturulabilir.")
	@Column(name="password")
	private String password;
	
	@NotBlank(message = "Şifre alanını boş bırakılmayınız")
	@Transient
	@JsonProperty(access = Access.WRITE_ONLY)
	private String passwordRepeat;

	@JsonIgnore
	@Column(name = "verify")
	private boolean verify = false;


}
