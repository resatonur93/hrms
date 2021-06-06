package com.onur.HRMSProject.business.abstracts;

import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.dtos.TechnologyDto;

import java.util.List;

public interface TechnologyService {
    Result add(TechnologyDto technologyDto);

    DataResult<List<TechnologyDto>> getAll();

}
