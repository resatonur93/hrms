package com.onur.HRMSProject.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VerifyCodeDao extends JpaRepository<VerifyCodeDao,Integer> {
    VerifyCodeDao getByVerifyCode(String Code);
    boolean existsByVerifyCode(String Code);


}
