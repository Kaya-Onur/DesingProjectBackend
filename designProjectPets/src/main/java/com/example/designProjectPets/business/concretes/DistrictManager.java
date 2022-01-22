package com.example.designProjectPets.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.designProjectPets.business.abstracts.DistrictService;
import com.example.designProjectPets.core.utilities.results.DataResult;
import com.example.designProjectPets.core.utilities.results.Result;
import com.example.designProjectPets.core.utilities.results.SuccessResult;
import com.example.designProjectPets.core.utilities.results.SuccessDataResult;
import com.example.designProjectPets.dataAccess.abstracts.DistrictDao;
import com.example.designProjectPets.entities.District;



@Service
public class DistrictManager implements DistrictService {

	private DistrictDao districtDao;

	@Autowired
	public DistrictManager(DistrictDao districtDao) {
		super();
		this.districtDao = districtDao;
	}

	@Override
	public Result districtAdd(District district) {
		this.districtDao.save(district);
		return new SuccessResult("İlçe eklendi");
	}

	@Override
	public Result districtDelete(int districtId) {
		District district=this.districtDao.getById(districtId);
		district.setDistrictStatus(false);
		this.districtDao.save(district);
		return new SuccessResult("İlçe güncellendi");
	}

	@Override
	public Result districtUpdate(District district) {
		return new SuccessDataResult<District>(this.districtDao.save(district),"İlçe güncellendi");
	}

	@Override
	public DataResult<List<District>> districtGetAll() {
		return new SuccessDataResult<List<District>>(this.districtDao.findAll(), "İlçeler listelendi");
	}
}

