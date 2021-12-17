package com.caguirre.fourqCA.service;

import java.util.List;

import com.caguirre.fourqCA.dto.UserDTO;

public interface IUserService {

	void saveUser(UserDTO userDTO);
	List<UserDTO> listUsers();
	UserDTO updateUser(UserDTO userDTO);
	void deleteUser(Long idUser);
	UserDTO findByid(Long idUser);
}
