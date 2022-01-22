package com.example.designProjectPets.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.designProjectPets.business.abstracts.AddressService;
import com.example.designProjectPets.core.utilities.results.DataResult;
import com.example.designProjectPets.core.utilities.results.Result;
import com.example.designProjectPets.core.utilities.results.SuccessResult;
import com.example.designProjectPets.core.utilities.results.SuccessDataResult;
import com.example.designProjectPets.dataAccess.abstracts.AddressDao;
import com.example.designProjectPets.entities.Address;


@Service
public class AddressManager implements AddressService {

	private AddressDao addressDao;
	
	@Autowired
	public AddressManager(AddressDao addressDao) {
		super();
		this.addressDao = addressDao;

	}

	@Override
	public Result addressAdd(Address address) {
		this.addressDao.save(address);
		return new SuccessResult("Adres eklendi");
	}

	@Override
	public Result addressDelete(int addressId) {
		Address address=this.addressDao.getById(addressId);
		address.setAddressStatus(false);
		this.addressDao.save(address);
		return new SuccessResult("Adres silindi");
	}

	@Override
	public Result addressUpdate(Address address) {
		return new SuccessDataResult<Address>(this.addressDao.save(address),"Adres güncellendi");
	}

	@Override
	public DataResult<List<Address>> addressGetAll() {
		return new SuccessDataResult<List<Address>>(this.addressDao.findAll(), "Adresler listelendi");
	}
}

