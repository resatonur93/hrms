package com.onur.HRMSProject.business.abstracts;

import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.dtos.LanguageDto;

import java.util.List;

public interface LanguageService {

    Result add(LanguageDto languageDto);
    DataResult<List<LanguageDto>> getAll();
}
