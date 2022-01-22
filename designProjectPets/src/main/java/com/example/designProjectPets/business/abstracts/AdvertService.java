package com.example.designProjectPets.business.abstracts;

import java.util.List;

import com.example.designProjectPets.core.utilities.results.DataResult;
import com.example.designProjectPets.core.utilities.results.Result;
import com.example.designProjectPets.entities.Advert;
import com.example.designProjectPets.entities.dtos.AdvertWithAddressDto;


public interface AdvertService {
	
	Result advertAdd(Advert advert);
	Result advertDelete(int advertId);
	DataResult<AdvertWithAddressDto> advertUpdate(AdvertWithAddressDto advertWithAddressDto);
	DataResult<List<Advert>> advertGetAll();
	
	DataResult<Advert> getByadvertId(int advertId);
	
	DataResult<AdvertWithAddressDto> advertWithAddressDto(AdvertWithAddressDto advertWithAddressDto);

}
