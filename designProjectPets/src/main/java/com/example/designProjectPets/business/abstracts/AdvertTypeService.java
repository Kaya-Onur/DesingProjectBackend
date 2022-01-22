package com.example.designProjectPets.business.abstracts;

import java.util.List;

import com.example.designProjectPets.core.utilities.results.DataResult;
import com.example.designProjectPets.core.utilities.results.Result;
import com.example.designProjectPets.entities.AdvertType;



public interface AdvertTypeService {
	
	Result advertTypeAdd(AdvertType advertType);
	Result advertTypeDelete(int advertTypeId);
	Result advertTypeUpdate(AdvertType advertType);
	DataResult<List<AdvertType>> advertTypeGetAll();
	
	 DataResult<AdvertType> getByadvertTypeId(int advertTypeId);

}
