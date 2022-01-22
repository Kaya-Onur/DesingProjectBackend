package com.example.designProjectPets.business.abstracts;

import java.util.List;

import com.example.designProjectPets.core.utilities.results.DataResult;
import com.example.designProjectPets.core.utilities.results.Result;
import com.example.designProjectPets.entities.Address;

public interface AddressService {

	Result addressAdd(Address address);
	Result addressDelete(int addressId);
	Result addressUpdate(Address address);
	DataResult<List<Address>> addressGetAll();
}
