package com.onur.HRMSProject.dataAcces.abstracts;

import com.onur.HRMSProject.entities.concretes.ConfirmEmployer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmEmployerDao extends JpaRepository<ConfirmEmployer, Integer> {

    ConfirmEmployer getByEmployer_Id(int id);
    boolean existsByEmployer_Id(int id);
}