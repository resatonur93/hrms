package com.onur.HRMSProject.dataAcces.abstracts;

import com.onur.HRMSProject.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CityDao extends JpaRepository<City,Integer>{

}
