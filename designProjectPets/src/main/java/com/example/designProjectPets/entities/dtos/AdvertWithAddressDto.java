package com.example.designProjectPets.entities.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.designProjectPets.core.utilities.shared.Views;
import com.example.designProjectPets.core.utilities.user.User;
import com.example.designProjectPets.entities.AdvertType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertWithAddressDto {
	
	//advert
	
	private int advertId;
	
	@NotNull
	@NotBlank
	private String advertPetName;
	
	@NotNull
	@NotBlank
	private String advertPhoneNumber;
	
	@NotNull
	private String advertDate;
	

	private boolean advertStatus;
	
	@NotNull
	private String advertUserEmail;
	
	@NotNull
	private String advertPhoto;
	
	//advertType
	@NotNull
	private int advertAdvertTypeId;
	
	
	//address
	@NotNull
	@NotBlank
	private String addressDescription;
	
	@NotNull
	private int cityId;
	
	@NotNull
	private int districtId;
	
	@NotNull
	private int neighbourhoodId;
	
	
	private boolean addressStatus;

}



  