package com.example.designProjectPets.entities;

import java.awt.Image;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.example.designProjectPets.core.utilities.shared.Views;
import com.example.designProjectPets.core.utilities.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "adverts")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Advert {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@JsonView(Views.Base.class)
	@Column(name = "advertId")
	private int advertId;
	
	@NotNull
	@NotBlank
	@JsonView(Views.Base.class)
	@Column(name = "advertPetName")
	private String advertPetName;
	
	@NotNull
	@NotBlank
	@JsonView(Views.Base.class)
	@Column(name = "advertPhoneNumber")
	private String advertPhoneNumber;
	
	@NotNull
	@JsonView(Views.Base.class)
	@Column(name = "advertDate")
	private String advertDate;
	
	@NotNull
	@JsonView(Views.Base.class)
	@Column(name="advertStatus")
	private boolean advertStatus;
	
	@NotNull
	@JsonView(Views.Base.class)
	@Lob
	@Column(name="advertPhoto")
	private String advertPhoto;
	

	
	// advertType ilişki
	@OneToOne()
		@JoinColumn(name = "advertTypeId", updatable = false)
		private AdvertType advertType;
	
	
	// advertType ilişki
		@OneToOne()
			@JoinColumn(name = "advertSortId", updatable = false)
			private AdvertSort advertSort;
		
		
		
		
				
				
				// address ilişki
				@OneToOne
				@JsonView(Views.Base.class)
				@JoinColumn(name = "addressId", updatable = false)
				private Address address;

				// kullanıcı ilişki
				@OneToOne()
				@JoinColumn(name = "userId", updatable = false)
				private User user;
				
				
				
				
}
