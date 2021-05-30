package com.onur.HRMSProject.dataAcces.abstracts;

import java.util.List;

import com.onur.HRMSProject.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
      List<JobAdvertisement> findByIsActiveTrue();
      List<JobAdvertisement> findByIsActiveTrueOrderByCreateDate();
      List<JobAdvertisement> findByIsActiveTrueAndEmployer_UserId(int userId);
      JobAdvertisement findByIdAndEmployer_UserId(int id, int userId);
}
