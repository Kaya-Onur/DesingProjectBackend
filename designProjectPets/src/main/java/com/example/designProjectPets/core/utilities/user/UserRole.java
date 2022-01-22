package com.example.designProjectPets.core.utilities.user;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "user_roles")
public class UserRole {
	
	@Id
	@GeneratedValue
	@Column(name="user_role_id")
	private long userRoleId;
	
	@NotNull
	@NotBlank
	@Column(name="user_Role")
	private String userRole;
	
	@JsonIgnore
	@OneToMany(mappedBy="userRole")
	private List<User> users;
	

}