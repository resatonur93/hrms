package com.onur.HRMSProject.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VerifyCode extends JpaRepository<VerifyCode,Integer> {
    VerifyCode getByVerifyCode(String Code);
    boolean existsByVerifyCode(String Code);
}
