package com.onur.HRMSProject.entities.concretes.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingAddDto {
   @JsonIgnore
   private int id;
   private int cityId;
   private int jobPositionId;
   private int employerId;
   private int openPositionNumber;
   private int minSalary;
   private int maxSalary;
   private String description;
   private Date createdDate;
   private Date closedDate;


}
