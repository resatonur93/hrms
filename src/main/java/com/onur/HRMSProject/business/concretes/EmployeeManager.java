package com.onur.HRMSProject.business.concretes;

import java.util.List;
import java.util.UUID;

import com.onur.HRMSProject.business.abstracts.EmployeeService;
import com.onur.HRMSProject.core.IdentityValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onur.HRMSProject.business.abstracts.UserService;
import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.ErrorResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.core.results.SuccessDataResult;
import com.onur.HRMSProject.core.results.SuccessResult;
import com.onur.HRMSProject.dataAcces.abstracts.EmployeeDao;
import com.onur.HRMSProject.entities.concretes.Employee;
import com.onur.HRMSProject.entities.concretes.User;
import com.onur.HRMSProject.entities.concretes.dtos.EmployeeForRegisterDto;


@Service
public class EmployeeManager implements EmployeeService {
	private EmployeeDao employeeDao;
	private UserService userService;
    private IdentityValidationService identityValidationService;
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao,UserService userService,IdentityValidationService identityValidationService) {
		super();
		this.employeeDao = employeeDao;
		this.userService = userService;
		this.identityValidationService = identityValidationService;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(employeeDao.findAll());
	}

	@Override
	public Result register(EmployeeForRegisterDto employee) {
		if(runAllRules(employee) != null) return runAllRules(employee);
		
	if(!identityValidationService.validate(employee.getNationalityId(), 
			employee.getFirstName(), 
			employee.getLastName(), 			
			employee.getDateOfBirth().getYear()).isSuccess()) {
			return new ErrorResult("TC Kimlik Numarası doğrulaması başarısız.");
		}
	
		User userToRegister = new User(employee.getEmail(), employee.getPassword(),false, UUID.randomUUID().toString());
		userService.add(userToRegister);
		Employee employeeToRegister = new Employee(userToRegister.getId(), 
				employee.getFirstName(),
				employee.getLastName(), 
				employee.getNationalityId(),
				employee.getDateOfBirth());
		this.employeeDao.save(employeeToRegister);
		return new SuccessResult("İş arayan kayıdı başarılı. Lütfen e-posta adresinize gönderilen doğrulama linkiyle hesabınızı doğrulayınız.");
	}
	
	private Result runAllRules(EmployeeForRegisterDto employee) {
		if(isAllFieldsFilled(employee) != null) return isAllFieldsFilled(employee);
		if(isPasswordsMatch(employee) != null) return isPasswordsMatch(employee);
		if(isUserExistWithEmail(employee) != null) return isUserExistWithEmail(employee);
		if(isUserExistWithNationalityId(employee) != null) return isUserExistWithNationalityId(employee);
		
		return null;
	}
	
	
	private Result isAllFieldsFilled(EmployeeForRegisterDto employee) {
		if(   employee.getVerifyPassword() == null || employee.getVerifyPassword().equals("") 
		  ||  employee.getPassword() == null  || employee.getPassword().equals("")
		  ||  employee.getEmail() == null || employee.getEmail().equals("")
		  ||  employee.getNationalityId() == null ||  employee.getNationalityId().equals("")
		  ||  employee.getLastName() == null || employee.getLastName().equals("")
		  ||  employee.getFirstName() == null || employee.getFirstName().equals("")
		  ||  employee.getDateOfBirth() == null)
			return new ErrorResult("Tüm alanları doldurmalısınız.");
		return null;
	}
	private Result isPasswordsMatch(EmployeeForRegisterDto employee) {
		if(!employee.getPassword().equals(employee.getVerifyPassword())) {
			return new ErrorResult("Şifreler uyuşmalıdır.");
		}
		return null;
	}
	
	private Result isUserExistWithEmail(EmployeeForRegisterDto employee) {
		if(userService.getByEmail(employee.getEmail()).getData() != null)
			return new ErrorResult("Bu e-posta adresiyle başka bir kullanıcı mevcut.");
		return null;
	}
	private Result isUserExistWithNationalityId(EmployeeForRegisterDto employee) {
		if(employeeDao.findByNationalityId(employee.getNationalityId()) != null)
			return new ErrorResult("Bu TCKN ile başka bir kullanıcı mevcut.");
		return null;
	}


	
}
