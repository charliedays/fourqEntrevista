package com.caguirre.fourqCA.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.caguirre.fourqCA.model.User;
import com.caguirre.fourqCA.repository.UserRepository;

@Controller
public class UserController {
    
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @GetMapping("/index")
    public String showIndex() {
//        model.addAttribute("users", userRepository.findAll());
        return "index";
    }
    
    @GetMapping("/users")
    public String showUsersList(Model model) {
        model.addAttribute("user", userRepository.findAll());
        return "users";
    }
    
    @GetMapping("/signup")
    public String showSignUpForm(User user) {
        return "signup_form";
    }
    
    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }
        
        userRepository.save(user);
        return "redirect:/index";
    }
    
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        
        return "update_form";
    }
    
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setIdUser(id);
            return "update_form";
        }
        
        System.out.println("USER NAME " + user.getName());
    	Optional <User> optional = userRepository.findById(id);
    	if(optional.isPresent()) {
    		User user2 = optional.get();
            System.out.println("USER NAME " + user2.getName());
            user2.setName(user.getName());
            user2.setEmail(user.getEmail());
            user2.setPassword(user.getPassword());
            user2.setRole(user.getRole());
            user2.setTelephone(user.getTelephone());
    		 userRepository.save(user2);
		}
        System.out.println("ID + " + id);
       

        return "redirect:/index";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        
        return "redirect:/index";
    }
}