package com.caguirre.fourqCA.service;

import java.util.List;

import com.caguirre.fourqCA.model.Role;


public interface IRoleService {

	void saveRole(Role role);
	List<Role> listUsers();
	
}
