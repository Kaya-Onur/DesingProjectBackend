package com.example.designProjectPets.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.designProjectPets.business.abstracts.CityService;
import com.example.designProjectPets.core.utilities.results.DataResult;
import com.example.designProjectPets.core.utilities.results.Result;
import com.example.designProjectPets.core.utilities.results.SuccessResult;
import com.example.designProjectPets.core.utilities.results.SuccessDataResult;
import com.example.designProjectPets.dataAccess.abstracts.CityDao;
import com.example.designProjectPets.entities.City;



@Service
public class CityManager implements CityService {
	
	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public Result cityAdd(City city) {
		this.cityDao.save(city);
		return new SuccessResult("Şehir eklendi");
	}

	@Override
	public Result cityDelete(int cityId) {
		City city=this.cityDao.getById(cityId);
		city.setCityStatus(false);
		this.cityDao.save(city);
		return new SuccessResult("Şehir güncellendi");
	}

	@Override
	public Result cityUpdate(City city) {
		return new SuccessDataResult<City>(this.cityDao.save(city), "Şehir bilgisi güncellendi");
	}

	@Override
	public DataResult<List<City>> cityGetAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Şehirler listelendi");
	}

	@Override
	public DataResult<City> getBycityId(int cityId) {
		return new SuccessDataResult<City>(this.cityDao.getBycityId(cityId),"Şehir listelendi.");
	}

}
