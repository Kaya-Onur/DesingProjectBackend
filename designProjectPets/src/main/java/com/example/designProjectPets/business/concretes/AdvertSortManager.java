package com.example.designProjectPets.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.designProjectPets.business.abstracts.AdvertSortService;
import com.example.designProjectPets.business.abstracts.AdvertTypeService;
import com.example.designProjectPets.core.utilities.results.DataResult;
import com.example.designProjectPets.core.utilities.results.Result;
import com.example.designProjectPets.core.utilities.results.SuccessDataResult;
import com.example.designProjectPets.core.utilities.results.SuccessResult;
import com.example.designProjectPets.dataAccess.abstracts.AdvertSortDao;
import com.example.designProjectPets.entities.AdvertSort;
import com.example.designProjectPets.entities.AdvertType;

@Service
public class AdvertSortManager implements AdvertSortService {
	
	private AdvertSortDao advertSortDao;


	@Autowired
	public AdvertSortManager(AdvertSortDao advertSortDao) {
		super();
		this.advertSortDao = advertSortDao;
	
	}


	@Override
	public Result advertSortAdd(AdvertSort advertSort) {
		return new SuccessDataResult<AdvertSort>(this.advertSortDao.save(advertSort),"İlan türü eklendi");
	}


	@Override
	public Result advertSortDelete(int advertSortId) {
		AdvertSort advertSort=this.advertSortDao.getByadvertSortId(advertSortId);
		advertSort.setAdvertSortStatus(false);
		this.advertSortDao.save(advertSort);
		return new SuccessResult("İlan türü silindi");
	}


	@Override
	public Result advertSortUpdate(AdvertSort advertSort) {
		return new SuccessDataResult<AdvertSort>(this.advertSortDao.save(advertSort),"İlan türü güncellendi");
	}


	@Override
	public DataResult<List<AdvertSort>> advertSortGetAll() {
		return new SuccessDataResult<List<AdvertSort>>(this.advertSortDao.findAll(), "İlan türleri listelendi");
	}


	@Override
	public DataResult<AdvertSort> getByadvertSortId(int advertSortId) {
		return new SuccessDataResult<AdvertSort>(this.advertSortDao.getByadvertSortId(advertSortId), "İlan türü listelendi");
	}

}
