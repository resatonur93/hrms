package com.onur.HRMSProject.dataAcces.abstracts;

import java.util.List;

import com.onur.HRMSProject.entities.concretes.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
      List<JobPosting> findByIsActive(boolean status);
      List<JobPosting> findByIsActiveTrueOrderByCreateDate(boolean status);
      List<JobPosting> findByIsActiveTrueAndEmployer_CompanyName(boolean status, String companyName);
}
