package com.example.designProjectPets.business.abstracts;

import java.util.List;

import com.example.designProjectPets.core.utilities.results.DataResult;
import com.example.designProjectPets.core.utilities.results.Result;
import com.example.designProjectPets.entities.AdvertSort;


public interface AdvertSortService {
	
	Result advertSortAdd(AdvertSort advertSort);
	Result advertSortDelete(int advertSortId);
	Result advertSortUpdate(AdvertSort advertSort);
	DataResult<List<AdvertSort>> advertSortGetAll();
	
	 DataResult<AdvertSort> getByadvertSortId(int advertSortId);


}
