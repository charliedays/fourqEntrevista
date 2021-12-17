package com.caguirre.fourqCA.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.caguirre.fourqCA.dto.UserDTO;
import com.caguirre.fourqCA.model.User;
import com.caguirre.fourqCA.repository.UserRepository;

@Service
public class UserService implements IUserService {
	
	  @Autowired
	    private UserRepository userRepo;
	  @Override
	    public List<UserDTO> listUsers(){
	    	List<UserDTO> users = new ArrayList<UserDTO>();
	        userRepo.findAll().forEach(user->users.add(user.getDTO()));

	    	return users;
	    }
	  
	@Override
	public void saveUser(UserDTO userDTO) {
	      BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
	        userDTO.setPassword(encodedPassword);
	        
	        User user = new User();
	        user.setDTO(userDTO);
	        userRepo.save(user);
	}

	@Override
	public UserDTO updateUser(UserDTO userDTO) {
	
		Optional <User> optional = userRepo.findById(userDTO.getId());
		if (optional.isPresent()) {
			User user = optional.get();
			user.setDTO(userDTO);
			userRepo.save(user);
		}
		
		return userDTO;
	}

	@Override
	public void deleteUser(Long idUser) {
		Optional <User> optional = userRepo.findById(idUser);
		if (optional.isPresent()) {
			User user = optional.get();
			userRepo.delete(user);
		}
	}

	@Override
	public UserDTO findByid(Long idUser) {
		Optional <User> optional = userRepo.findById(idUser);
		UserDTO user = null;
		if (optional.isPresent()) {
			user = optional.get().getDTO();
		
		}
		return user;
	}

	
	
}
 