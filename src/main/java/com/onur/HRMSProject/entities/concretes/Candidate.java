package com.onur.HRMSProject.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="candidate_users")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Candidate extends User {


	@NotBlank(message="İsim alanı boş bırakılamaz")
	@Size(min=3,message="İsim alanında en az 3 karakter kullanmalısınız")
	@Column(name="name")
	private String name;

	@NotBlank(message="Soyisim alanı boş bırakılamaz")
	@Column(name="sur_name")
	private String surname;

	@NotBlank(message="TCKN alanı boş bırakılamaz")
    @Size(min=11,max=11,message = "TCKN 11 haneli olmalıdır.")
	@Column(name="national_identity")
	private String nationalIdentity;

	@NotBlank(message = "Doğum yılı alanı boş bırakılamaz")
	@Column(name="birth_year")
	private Date birthYear;

}
