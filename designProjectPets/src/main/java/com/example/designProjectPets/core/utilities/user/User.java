package com.example.designProjectPets.core.utilities.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.designProjectPets.core.utilities.shared.Views;
import com.example.designProjectPets.entities.Advert;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6777810228300029536L;

	@Id
	@GeneratedValue
	@JsonView(Views.Base.class) // auth. sonrası başarılı cevap içinde dönecekleri belirledim.
	@Column(name = "user_id")
	private int userId;

	@NotNull
	@NotBlank
	@JsonView(Views.Base.class)
	@Size(min = 2, message = "İsim en az iki harfli olmalıdır")
	@Column(name = "user_first_name")
	private String userFirstName;

	@NotNull
	@NotBlank
	@JsonView(Views.Base.class)
	@Size(min = 2, message = "Soyisim en az iki harfli olmalıdır")
	@Column(name = "user_last_name")
	private String userLastName;

	@NotNull
	@NotBlank
	@Email
	@UniqueEmail
	@JsonView(Views.Base.class)
	@Column(name = "user_email")
	private String userEmail;
	
	@NotNull
	@NotBlank
	@JsonView(Views.Base.class)
	@Size(min=11,max = 11, message = "Telefon numarası 11 adet numaradan oluşmalıdır")
	@Column(name = "userPhoneNumber")
	private String userPhoneNumber;

	@NotNull
	@Size(min = 8, max = 255)
	@JsonView(Views.Sensitive.class)
	@Column(name = "user_password")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "Şifre en az bir küçük harf, bir büyük harf, bir rakam ve bir noktalama işareti içermelidir.")
	private String userPassword;
	
	@NotNull
	@JsonView(Views.Base.class)
	@Column(name = "userStatus")
	private boolean userStatus;

	@ManyToOne()
	@JoinColumn(name = "user_role_id", updatable = false, insertable = false)
	private UserRole userRole;

	@JsonView(Views.Base.class)
	@Column(name = "user_role_id", updatable = false)
	private int userRoleId;

	
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		 
		/*
		 * List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		 * authorities.add(new SimpleGrantedAuthority("Admin")); authorities.add(new
		 * SimpleGrantedAuthority("CompanyUser")); authorities.add(new
		 * SimpleGrantedAuthority("Driver"));
		 * 
		 * return authorities;
		 */
		 
		
		  if(getUserRoleId()==1) { 
			 return AuthorityUtils.createAuthorityList("Role_admin"); 
			 }
		  else{
			  return AuthorityUtils.createAuthorityList("Role_user");
			}
		  
		 
		
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getPassword() {
		return this.getUserPassword();
	}

	@Override
	public String getUsername() {
		return this.getUserEmail();
	}

}
