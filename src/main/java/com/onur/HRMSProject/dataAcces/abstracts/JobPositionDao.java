package com.onur.HRMSProject.dataAcces.abstracts;

import com.onur.HRMSProject.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
	boolean existsByPosition(String position);
}
