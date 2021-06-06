package com.onur.HRMSProject.entities.concretes.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceDto {
    @JsonIgnore
    private int id;
    private int resumeId;
    private String companyName;
    @Past(message = "Başlangıç tarihi bugünden sonra olamaz.")
    private Date startedDate;
    private Date endedDate;
    private int jobTitleId;

}
