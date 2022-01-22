package com.example.designProjectPets.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.designProjectPets.business.abstracts.NeighbourhoodService;
import com.example.designProjectPets.core.utilities.results.DataResult;
import com.example.designProjectPets.core.utilities.results.Result;
import com.example.designProjectPets.core.utilities.results.SuccessResult;
import com.example.designProjectPets.core.utilities.results.SuccessDataResult;
import com.example.designProjectPets.dataAccess.abstracts.NeighbourhoodDao;
import com.example.designProjectPets.entities.Neighbourhood;



@Service
public class NeighbourhoodManager implements NeighbourhoodService {
	
	private NeighbourhoodDao neighbourhoodDao;

	@Autowired
	public NeighbourhoodManager(NeighbourhoodDao neighbourhoodDao) {
		super();
		this.neighbourhoodDao = neighbourhoodDao;
	}

	@Override
	public Result neighbourhoodAdd(Neighbourhood neighbourhood) {
		this.neighbourhoodDao.save(neighbourhood);
		return new SuccessResult("Mahalle eklendi");
	}

	@Override
	public Result neighbourhoodDelete(int neighbourhoodId) {
		Neighbourhood neighbourhood=this.neighbourhoodDao.getById(neighbourhoodId);
		neighbourhood.setNeighbourhoodStatus(false);
		this.neighbourhoodDao.save(neighbourhood);
		return new SuccessResult("Mahalle güncellendi");
	}

	@Override
	public Result neighbourhoodUpdate(Neighbourhood neighbourhood) {
		return new SuccessDataResult<Neighbourhood>(this.neighbourhoodDao.save(neighbourhood),"Mahalle güncellendi");
	}

	@Override
	public DataResult<List<Neighbourhood>> neighbourhoodGetAll() {
		return new SuccessDataResult<List<Neighbourhood>>(this.neighbourhoodDao.findAll(), "Mahalleler listelendi");
	}

}
