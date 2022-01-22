package com.example.designProjectPets.core.utilities.error;

import java.util.Date;
import java.util.Map;

import com.example.designProjectPets.core.utilities.shared.Views;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Data
public class ApiError {
	
	@JsonView(Views.Base.class)
	private int status;
	
	@JsonView(Views.Base.class)
	private String message;
	
	@JsonView(Views.Base.class)
	private String path;
	
	@JsonView(Views.Base.class)
	private long timeStamp=new Date().getTime();
	
	@JsonView(Views.Base.class)
	private Map<String,String> validationErrors;
	
	public ApiError(int status, String message, String path) {
		this.status = status;
		this.message = message;
		this.path = path;
	}

}
