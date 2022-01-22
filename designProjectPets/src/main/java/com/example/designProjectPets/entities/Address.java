package com.example.designProjectPets.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.example.designProjectPets.core.utilities.shared.Views;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "addresses")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@JsonView(Views.Base.class)
	@Column(name = "addressId")
	private int addressId;

	@NotNull
	@NotBlank
	@JsonView(Views.Base.class)
	@Column(name = "addressDescription")
	private String addressDescription;
	
	@NotNull
	@JsonView(Views.Base.class)
	@Column(name="addressStatus")
	private boolean addressStatus;

	// city ilişki
	@ManyToOne()
	@JoinColumn(name = "cityId", updatable = false, insertable = false)
	private City city;

	@JsonView(Views.Base.class)
	@Column(name = "cityId", updatable = false)
	private int cityId;

	
	  // district ilişki
	  
	  @ManyToOne()
	  @JoinColumn(name = "districtId", updatable = false, insertable = false)
	  private District district;
	  
	  @JsonView(Views.Base.class)
	  @Column(name = "districtId", updatable = false) 
	  private int districtId;
	 

	// neighbourhood ilişki
	@ManyToOne()
	@JoinColumn(name = "neighbourhoodId", updatable = false, insertable = false)
	private Neighbourhood neighbourhood;

	@JsonView(Views.Base.class)
	@Column(name = "neighbourhoodId", updatable = false)
	private int neighbourhoodId;


}
