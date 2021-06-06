package com.onur.HRMSProject.business.concretes;

import com.onur.HRMSProject.business.abstracts.LanguageService;
import com.onur.HRMSProject.core.dtoConvertor.DtoConverterService;
import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.core.results.SuccessDataResult;
import com.onur.HRMSProject.core.results.SuccessResult;
import com.onur.HRMSProject.dataAcces.abstracts.LanguageDao;
import com.onur.HRMSProject.entities.concretes.Language;
import com.onur.HRMSProject.entities.concretes.dtos.LanguageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LanguageManager implements LanguageService {

    private LanguageDao languageDao;
    private DtoConverterService dtoConverterService;

    @Autowired
    public LanguageManager(LanguageDao languageDao, DtoConverterService dtoConverterService) {
        super();
        this.languageDao = languageDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public Result add(LanguageDto languageDto) {
        languageDao.save((Language) dtoConverterService.dtoClassConverter(languageDto, LanguageDto.class));
        return new SuccessResult("Başarıyla Eklendi");
    }

    @Override
    public DataResult<List<LanguageDto>> getAll() {
        return new SuccessDataResult<List<LanguageDto>>
                (this.dtoConverterService.dtoConverter(languageDao.findAll(),LanguageDto.class), "Data Listelendi");
    }


}