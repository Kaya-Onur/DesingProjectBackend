package com.example.designProjectPets.business.concretes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;

import com.example.designProjectPets.business.abstracts.AdvertService;
import com.example.designProjectPets.core.utilities.results.DataResult;
import com.example.designProjectPets.core.utilities.results.Result;
import com.example.designProjectPets.core.utilities.results.SuccessDataResult;
import com.example.designProjectPets.core.utilities.results.SuccessResult;
import com.example.designProjectPets.core.utilities.user.User;
import com.example.designProjectPets.core.utilities.user.UserDao;
import com.example.designProjectPets.dataAccess.abstracts.AddressDao;
import com.example.designProjectPets.dataAccess.abstracts.AdvertDao;
import com.example.designProjectPets.dataAccess.abstracts.AdvertTypeDao;
import com.example.designProjectPets.entities.Address;
import com.example.designProjectPets.entities.Advert;
import com.example.designProjectPets.entities.AdvertType;
import com.example.designProjectPets.entities.dtos.AdvertWithAddressDto;

@Service
public class AdvertManager implements AdvertService {
	
	private AdvertDao advertDao;
	private AddressDao addressDao;
	private UserDao userDao;
	private AdvertTypeDao AdvertTypeDao;

	@Autowired
	public AdvertManager(AdvertDao advertDao,AddressDao addressDao,UserDao userDao,AdvertTypeDao AdvertTypeDao) {
		super();
		this.advertDao = advertDao;
		this.addressDao=addressDao;
		this.userDao=userDao;
		this.AdvertTypeDao=AdvertTypeDao;
	}

	@Override
	public Result advertAdd(Advert advert) {
		return new SuccessDataResult<Advert>(this.advertDao.save(advert), "İlan eklendi.");
	}

	@Override
	public Result advertDelete(int advertId) {
		Advert advert=this.advertDao.getById(advertId);
		advert.setAdvertStatus(false);
		this.advertDao.save(advert);
		return new SuccessResult("İlan silindi");
	}

	

	@Override
	public DataResult<List<Advert>> advertGetAll() {
		return new SuccessDataResult<List<Advert>>(this.advertDao.findAll(), "İlanlar listelendi");
	}

	@Override
	public DataResult<AdvertWithAddressDto> advertWithAddressDto(AdvertWithAddressDto advertWithAddressDto) {
		

		Address address=new Address();
		address.setAddressDescription(advertWithAddressDto.getAddressDescription());
		address.setCityId(advertWithAddressDto.getCityId());	
		address.setDistrictId(advertWithAddressDto.getDistrictId());
		address.setNeighbourhoodId(advertWithAddressDto.getNeighbourhoodId());
		address.setAddressStatus(true);
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime now=LocalDateTime.now();
		String nowAdvert =now.format(formatter);
		
		
		
		AdvertType advertType=this.AdvertTypeDao.getByadvertTypeId(advertWithAddressDto.getAdvertAdvertTypeId());
		User user=this.userDao.findByUserEmail(advertWithAddressDto.getAdvertUserEmail());
		
		
		
		Advert advert=new Advert();
		advert.setAddress(this.addressDao.save(address));
		advert.setAdvertDate(nowAdvert);
		advert.setAdvertPetName(advertWithAddressDto.getAdvertPetName());
		advert.setAdvertType(advertType);
		advert.setAdvertStatus(true);
		advert.setAdvertPhoneNumber(advertWithAddressDto.getAdvertPhoneNumber());
		advert.setAdvertPhoto(advertWithAddressDto.getAdvertPhoto());
		advert.setUser(user);
		
		this.advertDao.save(advert);
		
		return new SuccessDataResult<AdvertWithAddressDto>(advertWithAddressDto, "İlan eklendi.");
	}

	@Override
	public DataResult<Advert> getByadvertId(int advertId) {
		
		return new SuccessDataResult<Advert>(this.advertDao.getByadvertId(advertId), "İlan listelendi.");
	}

	@Override
	public DataResult<AdvertWithAddressDto> advertUpdate(AdvertWithAddressDto advertWithAddressDto) {
		Address address=new Address();
		address.setAddressDescription(advertWithAddressDto.getAddressDescription());
		address.setCityId(advertWithAddressDto.getCityId());	
		address.setDistrictId(advertWithAddressDto.getDistrictId());
		address.setNeighbourhoodId(advertWithAddressDto.getNeighbourhoodId());
		address.setAddressStatus(true);
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime now=LocalDateTime.now();
		String nowAdvert =now.format(formatter);
		
		
		
		AdvertType advertType=this.AdvertTypeDao.getByadvertTypeId(advertWithAddressDto.getAdvertAdvertTypeId());
		User user=this.userDao.findByUserEmail(advertWithAddressDto.getAdvertUserEmail());
		
		
		
		Advert advert=this.getByadvertId(advertWithAddressDto.getAdvertId()).getData();
		advert.setAddress(this.addressDao.save(address));
		advert.setAdvertDate(nowAdvert);
		advert.setAdvertPetName(advertWithAddressDto.getAdvertPetName());
		advert.setAdvertType(advertType);
		advert.setAdvertStatus(true);
		advert.setAdvertPhoneNumber(advertWithAddressDto.getAdvertPhoneNumber());
		advert.setAdvertPhoto(advertWithAddressDto.getAdvertPhoto());
		advert.setUser(user);
		
		this.advertDao.save(advert);
		
		return new SuccessDataResult<AdvertWithAddressDto>(advertWithAddressDto, "İlan güncellendi.");
	}

}
