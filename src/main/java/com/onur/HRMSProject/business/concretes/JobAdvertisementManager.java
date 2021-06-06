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
		
		// Aslında burası authenticationdan gelecek fakat şu an öğrenmedik, o yüzden el ile istiyoruz :)
		if(!employerService.getById(jobAdvertisement.getEmployerId()).isSuccess()) {
			return new ErrorResult("Böyle bir iş veren firma yok.");
		}
		
		
		//Automapper entegrasyonu ile çok daha clean hale getirilebilir.
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
		
		return new SuccessResult("İş ilanı başarı ile oluşturuldu.");
	}
	

	@Override
	public Result changeStatus(int advertisementId, int employerId) {
		JobPosting jobPostingToUpdate = jobPostingDao.findByIdAndEmployer_UserId(advertisementId, employerId);
		if(jobPostingToUpdate ==null) return new ErrorResult("Bu kriterlere uyan bir iş ilanı bulamadı. Böyle bir iş ilanı yok veya bu iş ilanı bu şirkete ait değil");
		jobPostingToUpdate.setActive(!jobPostingToUpdate.isActive());
		jobPostingDao.save(jobPostingToUpdate);
		return new SuccessResult("Belirtilen iş ilanı " + (jobPostingToUpdate.isActive() ? "aktif" : "pasif") + " hale getirildi.");
	}
	
	private Result isJobPositionValid(int id) {
		if(id<=0) return new ErrorResult("İş pozisyonu doğru girilmedi.");
		if(jobPositionService.getById(id).getData() == null) return new ErrorResult("Böyle bir iş pozisyonu yok.");
		return new SuccessResult();
	}
	private Result isJobDescValid(String jobDesc) {
		if(jobDesc == null || jobDesc.equals("")) return new ErrorResult("İş açıklaması doğru girilmedi");
		return new SuccessResult();
	}
	private Result isCityValid(int id) {
		if(id<=0) return new ErrorResult("Şehir doğru girilmedi");
		if(cityService.getById(id).getData() == null) return new ErrorResult("Böyle bir şehir yok.");
		return new SuccessResult();
	}
	private Result isOpenPositionValid(int count) {
		if(count<=0) return new ErrorResult("Açık iş pozisyonu 0 ve 0'dan küçük olamaz.");
		return new SuccessResult();
	}
	private Result isEndDateValid(Date endDate) {

		if(new Date().compareTo(endDate) > 0) {
			return new ErrorResult("Son başvuru tarihi iş ilanı tarihinden önce olamaz.");
		}
		return new SuccessResult();
	}




}
