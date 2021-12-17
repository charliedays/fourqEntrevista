package com.caguirre.fourqCA;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.caguirre.fourqCA.model.User;
import com.caguirre.fourqCA.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class FourqCaApplicationTests {

	 @Autowired
	    private TestEntityManager entityManager;
	     
	    @Autowired
	    private UserRepository repo;

	    @Test
	    public void testCreateUser() {
	        User user = new User();
	        user.setEmail("ravikumar@gmail.com");
	        user.setPassword("ravi2020");
	        user.setName("Ravi");
	        user.setTelephone(81214120);
	        user.setRole("1");
//	        user.setLastName("Kumar");
	         
	        User savedUser = repo.save(user);
	         
	        User existUser = entityManager.find(User.class, savedUser.getIdUser());
	         
	        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
	         
	    }
	
}
