package com.onur.HRMSProject.api.controllers;

import com.onur.HRMSProject.business.abstracts.VerifyCodeService;
import com.onur.HRMSProject.core.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/valid")
public class VerifyCodeController {

    private VerifyCodeService verifyCodeService;

    @Autowired
    public VerifyCodeController(VerifyCodeService verifyCodeService) {
        super();
        this.verifyCodeService = verifyCodeService;
    }


    @PutMapping("/{verifyCode}")
    public Result update(@PathVariable("verifyCode") String verifyCode) {
        return verifyCodeService.verifyUser(verifyCode);
    }


}