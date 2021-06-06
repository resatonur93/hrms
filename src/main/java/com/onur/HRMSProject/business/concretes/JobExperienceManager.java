package com.onur.HRMSProject.business.concretes;

import com.onur.HRMSProject.business.abstracts.JobExperienceService;
import com.onur.HRMSProject.core.dtoConvertor.DtoConverterService;
import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.core.results.SuccessDataResult;
import com.onur.HRMSProject.core.results.SuccessResult;
import com.onur.HRMSProject.dataAcces.abstracts.JobExperienceDao;
import com.onur.HRMSProject.entities.concretes.JobExperience;
import com.onur.HRMSProject.entities.concretes.dtos.JobExperienceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobExperienceManager implements JobExperienceService {

    private JobExperienceDao jobExperienceDao;
    private DtoConverterService dtoConverterService;

    @Autowired
    public JobExperienceManager(JobExperienceDao jobExperienceDao, DtoConverterService dtoConverterService) {
        super();
        this.jobExperienceDao = jobExperienceDao;
        this.dtoConverterService = dtoConverterService;
    }


    @Override
    public Result add(JobExperienceDto jobExperienceDto) {
        jobExperienceDao.save((JobExperience) dtoConverterService.dtoClassConverter(jobExperienceDto, JobExperience.class));
        return new SuccessResult("Başarıyla Eklendi");
    }

    @Override
    public SuccessDataResult<List<JobExperienceDto>> getAll() {
        return new SuccessDataResult<List<JobExperienceDto>>
                (this.dtoConverterService.dtoConverter(this.jobExperienceDao.findAll(),JobExperienceDto.class),"Data Listelendi");
    }


    @Override
    public DataResult<List<JobExperienceDto>> findAllByResumeIdOrderByEndedDateDesc(int id) {
        return new SuccessDataResult<List<JobExperienceDto>>
                (this.dtoConverterService.dtoConverter(this.jobExperienceDao.findAllByResumeIdOrderByEndedDateDesc(id),JobExperienceDto.class),"Data Listelendi");
    }



}