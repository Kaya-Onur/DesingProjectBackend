package com.example.designProjectPets.core.utilities.shared;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.security.core.annotation.AuthenticationPrincipal;



@Target(value={ElementType.PARAMETER})
@Retention(value=RetentionPolicy.RUNTIME)
@AuthenticationPrincipal()
public @interface CurrentUser {

	//metot içine login olan user i inject edildi.
}
