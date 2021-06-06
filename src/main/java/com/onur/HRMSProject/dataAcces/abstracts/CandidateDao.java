package com.onur.HRMSProject.dataAcces.abstracts;

import com.onur.HRMSProject.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateDao extends JpaRepository<Candidate, Integer> {

    boolean existsByNationalIdentity(String national_identity);


}
