package com.onur.HRMSProject.business.abstracts;

import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.Graduate;

import java.util.List;

public interface GraduateService {
    DataResult<List<Graduate>> getAll();
    Result add(Graduate graduate);
}
