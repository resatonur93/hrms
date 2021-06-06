package com.onur.HRMSProject.entities.concretes.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingDto {
   private String jobDescription;
   private Double minSalary;
   private Double maxSalary;
   private int openPositionCount;
   private Date lastApplyDate;
   private boolean isActive;
   private int cityId;
   private int jobPositionId;
   private int employerId;
}