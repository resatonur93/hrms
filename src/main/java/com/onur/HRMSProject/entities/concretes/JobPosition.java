package com.onur.HRMSProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="job_positions")
public class JobPosition {
	
	@Id
	@GeneratedValue
	@Column(name="id", nullable=false)
	private int id;

	@Column(name="position_name", unique=true)
	private String positionName;
}
