package com.example.designProjectPets.business.abstracts;

import java.util.List;

import com.example.designProjectPets.core.utilities.results.DataResult;
import com.example.designProjectPets.core.utilities.results.Result;
import com.example.designProjectPets.entities.Neighbourhood;

public interface NeighbourhoodService {
	
	Result neighbourhoodAdd(Neighbourhood neighbourhood);
	Result neighbourhoodDelete(int neighbourhoodId);
	Result neighbourhoodUpdate(Neighbourhood neighbourhood);
	DataResult<List<Neighbourhood>> neighbourhoodGetAll();

}
