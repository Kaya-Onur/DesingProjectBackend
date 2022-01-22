package com.example.designProjectPets.business.abstracts;

import java.util.List;

import com.example.designProjectPets.core.utilities.results.DataResult;
import com.example.designProjectPets.core.utilities.results.Result;
import com.example.designProjectPets.entities.City;

public interface CityService {
	
	Result cityAdd(City city);
	Result cityDelete(int cityId);
	Result cityUpdate(City city);
	DataResult<List<City>> cityGetAll();
	
	DataResult<City> getBycityId(int cityId);

}
