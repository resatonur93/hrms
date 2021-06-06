package com.onur.HRMSProject.business.abstracts;

import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.Language;

import java.util.List;

public interface LanguageService {

    DataResult<List<Language>> getAll();
    Result add(Language language);
}
