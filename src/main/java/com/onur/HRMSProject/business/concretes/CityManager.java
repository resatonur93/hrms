package com.onur.HRMSProject.business.concretes;

import java.util.List;

import com.onur.HRMSProject.business.abstracts.CityService;
import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.ErrorDataResult;
import com.onur.HRMSProject.core.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onur.HRMSProject.dataAcces.abstracts.CityDao;
import com.onur.HRMSProject.entities.concretes.City;


@Service
public class CityManager implements CityService {

	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		
		return new SuccessDataResult<List<City>>(cityDao.findAll());
	}

	@Override
	public DataResult<City> getById(int id) {
		City city = cityDao.findById(id);
		if(city==null) return new ErrorDataResult<City>();
		return new SuccessDataResult<City>(city);
	}

	

}
