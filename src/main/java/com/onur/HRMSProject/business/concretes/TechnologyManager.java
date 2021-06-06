package com.onur.HRMSProject.business.concretes;

import com.onur.HRMSProject.business.abstracts.TechnologyService;
import com.onur.HRMSProject.core.dtoConvertor.DtoConverterService;
import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.core.results.SuccessDataResult;
import com.onur.HRMSProject.core.results.SuccessResult;
import com.onur.HRMSProject.dataAcces.abstracts.TechnologyDao;
import com.onur.HRMSProject.entities.concretes.Technology;
import com.onur.HRMSProject.entities.concretes.dtos.TechnologyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {

    private TechnologyDao technologyDao;
    private DtoConverterService dtoConverterService;

    @Autowired
    public TechnologyManager(TechnologyDao technologyDao, DtoConverterService dtoConverterService) {
        super();
        this.technologyDao = technologyDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public Result add(TechnologyDto technologyDto) {
        technologyDao.save((Technology) dtoConverterService.dtoClassConverter(technologyDto, Technology.class));
        return new SuccessResult("Başarıyla Eklendi");
    }

    @Override
    public DataResult<List<TechnologyDto>> getAll() {
        return new SuccessDataResult<List<TechnologyDto>>
                (dtoConverterService.dtoConverter(technologyDao.findAll(),TechnologyDto.class),"Başarıyla Listelendi");
    }



}