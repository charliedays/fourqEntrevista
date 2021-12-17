package com.caguirre.fourqCA.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.caguirre.fourqCA.dto.UserDTO;


@Entity
@Table(name="fq_users")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
	
	private String name;
	private String email;
	private String password;
	private Integer telephone;
	private String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getTelephone() {
		return telephone;
	}
	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", telephone=" + telephone + ", role=" + role + "]";
	}

	public UserDTO getDTO() {
		
		UserDTO userDTO = new UserDTO();
		
		userDTO.setId(idUser);
		userDTO.setEmail(email);
		userDTO.setName(name);
		userDTO.setPassword(password);
		userDTO.setRole(role);
		userDTO.setTelephone(telephone);
		
		return userDTO;
	}
	
	public void setDTO(UserDTO userDTO) {
		this.idUser=userDTO.getId();
		this.name = userDTO.getName();
		this.password = userDTO.getPassword();
		this.telephone = userDTO.getTelephone();
		this.role = userDTO.getRole();
		this.email = userDTO.getEmail();
		
	}
}
