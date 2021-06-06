package com.onur.HRMSProject.business.concretes;

import com.onur.HRMSProject.business.abstracts.EducationService;
import com.onur.HRMSProject.core.dtoConvertor.DtoConverterService;
import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.core.results.SuccessDataResult;
import com.onur.HRMSProject.core.results.SuccessResult;
import com.onur.HRMSProject.dataAcces.abstracts.EducationDao;
import com.onur.HRMSProject.entities.concretes.Education;
import com.onur.HRMSProject.entities.concretes.dtos.EducationDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EducationManager implements EducationService {
    private EducationDao educationDao;
    private DtoConverterService dtoConverterService;

    @Autowired
    public EducationManager(EducationDao educationDao, DtoConverterService dtoConverterService) {
        super();
        this.educationDao = educationDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public Result add(EducationDto educationDto) {
        educationDao.save((Education) dtoConverterService.dtoClassConverter(educationDto, Education.class));
        return new SuccessResult("Başarıyla Eklendi");
    }

    @Override
    public DataResult<List<EducationDto>> getAll() {
        return new SuccessDataResult<List<EducationDto>>(dtoConverterService.dtoConverter(educationDao.findAll(), EducationDto.class));

    }

    @Override
    public DataResult<List<EducationDto>> findAllByResumeIdOrderByEndedDateDesc(int id) {
        return new SuccessDataResult<List<EducationDto>>(dtoConverterService.dtoConverter(educationDao.findAllByResumeIdOrderByEndedDateDesc(id), EducationDto.class));
    }


}