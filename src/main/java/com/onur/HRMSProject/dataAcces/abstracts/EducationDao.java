package com.onur.HRMSProject.dataAcces.abstracts;

import com.onur.HRMSProject.entities.concretes.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationDao extends JpaRepository<Education, Integer> {
}
