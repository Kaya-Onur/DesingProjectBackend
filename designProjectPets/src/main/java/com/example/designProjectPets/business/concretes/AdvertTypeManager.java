package com.example.designProjectPets.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.designProjectPets.business.abstracts.AdvertTypeService;
import com.example.designProjectPets.core.utilities.results.DataResult;
import com.example.designProjectPets.core.utilities.results.Result;
import com.example.designProjectPets.core.utilities.results.SuccessDataResult;
import com.example.designProjectPets.core.utilities.results.SuccessResult;
import com.example.designProjectPets.dataAccess.abstracts.AdvertTypeDao;
import com.example.designProjectPets.entities.AdvertType;

@Service
public class AdvertTypeManager implements AdvertTypeService {
	
	private AdvertTypeDao advertTypeDao;


	@Autowired
	public AdvertTypeManager(AdvertTypeDao advertTypeDao) {
		super();
		this.advertTypeDao = advertTypeDao;
	
	}

	@Override
	public Result advertTypeAdd(AdvertType advertType) {
		return new SuccessDataResult<AdvertType>(this.advertTypeDao.save(advertType),"İlan tipi eklendi");
	}

	@Override
	public Result advertTypeDelete(int advertTypeId) {
		AdvertType advertType=this.advertTypeDao.getById(advertTypeId);
		advertType.setAdvertTypeStatus(false);
		this.advertTypeDao.save(advertType);
		return new SuccessResult("İlan tipi silindi");
	}

	@Override
	public Result advertTypeUpdate(AdvertType advertType) {
		return new SuccessDataResult<AdvertType>(this.advertTypeDao.save(advertType),"İlan tipi güncellendi");
	}

	@Override
	public DataResult<List<AdvertType>> advertTypeGetAll() {
		return new SuccessDataResult<List<AdvertType>>(this.advertTypeDao.findAll(), "İlan tipleri listelendi");
	}

	@Override
	public DataResult<AdvertType> getByadvertTypeId(int advertTypeId) {
		return new SuccessDataResult<AdvertType>(this.advertTypeDao.getByadvertTypeId(advertTypeId), "İlan tipi listelendi");
	}

}
