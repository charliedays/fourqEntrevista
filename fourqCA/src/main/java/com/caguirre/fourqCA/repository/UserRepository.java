package com.caguirre.fourqCA.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.caguirre.fourqCA.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	public User findByEmail(String email);
	 List<User> findByName(String name);
}
