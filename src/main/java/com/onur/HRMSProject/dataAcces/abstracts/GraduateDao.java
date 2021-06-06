package com.onur.HRMSProject.dataAcces.abstracts;

import com.onur.HRMSProject.entities.concretes.Graduate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GraduateDao extends JpaRepository<Graduate,Integer> {
    boolean existsByDescription(String description);
}
