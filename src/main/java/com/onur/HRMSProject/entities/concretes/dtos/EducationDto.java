package com.onur.HRMSProject.entities.concretes.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {
    @JsonIgnore
    private int id;
    private int resumeId;
    private String schoolName;
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    private  int graduateId;
    private String graduateDescription;
    private String schoolDepartment;
    private Date startedDate;
    private Date endedDate;
    private Date createdDate;

}
