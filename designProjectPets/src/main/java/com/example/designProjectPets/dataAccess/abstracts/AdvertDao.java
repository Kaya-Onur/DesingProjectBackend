package com.example.designProjectPets.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.designProjectPets.entities.Advert;



public interface AdvertDao extends JpaRepository<Advert, Integer>  {
	
	Advert getByadvertId(int advertId);

}
