package com.onur.HRMSProject.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class JobPostingDto {

    private String employerCompanyName;
    private String jobPositionPosition;
    private int openPositionNumber;
    private Date createdDate;
    private Date closedDate;
    private String description;


}