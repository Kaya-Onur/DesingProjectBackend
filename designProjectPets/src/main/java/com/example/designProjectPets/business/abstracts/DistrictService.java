package com.example.designProjectPets.business.abstracts;

import java.util.List;

import com.example.designProjectPets.core.utilities.results.DataResult;
import com.example.designProjectPets.core.utilities.results.Result;
import com.example.designProjectPets.entities.District;

public interface DistrictService {
	
	Result districtAdd(District district);
	Result districtDelete(int districtId);
	Result districtUpdate(District district);
	DataResult<List<District>> districtGetAll();

}
