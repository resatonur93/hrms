package com.onur.HRMSProject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "confirm_employer_users")
public class ConfirmEmployer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @JsonIgnore
    private int Id;

    @OneToOne(targetEntity = Employer.class)
    @JoinColumn(name="employer_id", referencedColumnName="user_id")
    private Employer employer;

    @Column(name = "confirmed_staff_user")
    private int staffUser;

    @Column(name="confirmed_date")
    private Date confirmedDate;

    @Column(name="is_confirmed")
    private boolean isConfirmed;
}
