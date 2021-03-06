package com.onur.HRMSProject.business.concretes;

import java.util.Date;
import java.util.List;

import com.onur.HRMSProject.business.abstracts.CityService;
import com.onur.HRMSProject.business.abstracts.EmployerService;
import com.onur.HRMSProject.business.abstracts.JobAdvertisementService;
import com.onur.HRMSProject.business.abstracts.JobPositionService;
import com.onur.HRMSProject.core.Validation.BusinessRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.ErrorResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.core.results.SuccessDataResult;
import com.onur.HRMSProject.core.results.SuccessResult;
import com.onur.HRMSProject.dataAcces.abstracts.JobPostingDao;
import com.onur.HRMSProject.entities.concretes.JobPosting;
import com.onur.HRMSProject.entities.concretes.dtos.JobPostingAddDto;



@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobPostingDao jobPostingDao;
	private EmployerService employerService;
	private JobPositionService jobPositionService;
	private CityService cityService;


	

    @Autowired
	public JobAdvertisementManager(JobPostingDao jobPostingDao, EmployerService employerService,
								   JobPositionService jobPositionService, CityService cityService) {
		super();
		this.jobPostingDao = jobPostingDao;
		this.employerService = employerService;
		this.jobPositionService = jobPositionService;
		this.cityService = cityService;
	}



	@Override
	public DataResult<List<JobPosting>> findByIsActiveTrue() {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.findByIsActiveTrue());
	}



	@Override
	public DataResult<List<JobPosting>> findByIsActiveTrueOrderByCreateDate() {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.findByIsActiveTrueOrderByCreateDate());
	}



	@Override
	public DataResult<List<JobPosting>> findByEmployer_EmployerId(int employerId) {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.findByIsActiveTrueAndEmployer_UserId(employerId));
	}



	@Override
	public Result addNew(JobPostingAddDto jobAdvertisement) {
		Result businessRulesResult = BusinessRules.run(
				isJobPositionValid(jobAdvertisement.getJobPositionId()),
				isJobDescValid(jobAdvertisement.getJobDescription()),
				isCityValid(jobAdvertisement.getCityId()),
				isOpenPositionValid(jobAdvertisement.getOpenPositionCount()),
				isEndDateValid(jobAdvertisement.getLastApplyDate())
				);
		if ( businessRulesResult != null ) return businessRulesResult;
		
		// Asl??nda buras?? authenticationdan gelecek fakat ??u an ????renmedik, o y??zden el ile istiyoruz :)
		if(!employerService.getById(jobAdvertisement.getEmployerId()).isSuccess()) {
			return new ErrorResult("B??yle bir i?? veren firma yok.");
		}
		
		
		//Automapper entegrasyonu ile ??ok daha clean hale getirilebilir.
		JobPosting jobPostingToAdd = new JobPosting(jobAdvertisement.getJobDescription(),
				jobAdvertisement.getMinSalary(), 
				jobAdvertisement.getMaxSalary(), 
				jobAdvertisement.getOpenPositionCount(), 
				jobAdvertisement.getLastApplyDate(), 
				new Date(), 
				jobAdvertisement.isActive());
		jobPostingToAdd.setCity(cityService.getById(jobAdvertisement.getCityId()).getData());
		jobPostingToAdd.setJobPosition(jobPositionService.getById(jobAdvertisement.getJobPositionId()).getData());
		jobPostingToAdd.setEmployer(employerService.getById(jobAdvertisement.getEmployerId()).getData());
		jobPostingDao.save(jobPostingToAdd);
		
		return new SuccessResult("???? ilan?? ba??ar?? ile olu??turuldu.");
	}
	

	@Override
	public Result changeStatus(int advertisementId, int employerId) {
		JobPosting jobPostingToUpdate = jobPostingDao.findByIdAndEmployer_UserId(advertisementId, employerId);
		if(jobPostingToUpdate ==null) return new ErrorResult("Bu kriterlere uyan bir i?? ilan?? bulamad??. B??yle bir i?? ilan?? yok veya bu i?? ilan?? bu ??irkete ait de??il");
		jobPostingToUpdate.setActive(!jobPostingToUpdate.isActive());
		jobPostingDao.save(jobPostingToUpdate);
		return new SuccessResult("Belirtilen i?? ilan?? " + (jobPostingToUpdate.isActive() ? "aktif" : "pasif") + " hale getirildi.");
	}
	
	private Result isJobPositionValid(int id) {
		if(id<=0) return new ErrorResult("???? pozisyonu do??ru girilmedi.");
		if(jobPositionService.getById(id).getData() == null) return new ErrorResult("B??yle bir i?? pozisyonu yok.");
		return new SuccessResult();
	}
	private Result isJobDescValid(String jobDesc) {
		if(jobDesc == null || jobDesc.equals("")) return new ErrorResult("???? a????klamas?? do??ru girilmedi");
		return new SuccessResult();
	}
	private Result isCityValid(int id) {
		if(id<=0) return new ErrorResult("??ehir do??ru girilmedi");
		if(cityService.getById(id).getData() == null) return new ErrorResult("B??yle bir ??ehir yok.");
		return new SuccessResult();
	}
	private Result isOpenPositionValid(int count) {
		if(count<=0) return new ErrorResult("A????k i?? pozisyonu 0 ve 0'dan k??????k olamaz.");
		return new SuccessResult();
	}
	private Result isEndDateValid(Date endDate) {

		if(new Date().compareTo(endDate) > 0) {
			return new ErrorResult("Son ba??vuru tarihi i?? ilan?? tarihinden ??nce olamaz.");
		}
		return new SuccessResult();
	}




}
