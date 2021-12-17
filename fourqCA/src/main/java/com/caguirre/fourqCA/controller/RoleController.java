package com.caguirre.fourqCA.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.caguirre.fourqCA.model.Role;
import com.caguirre.fourqCA.repository.RoleRepository;

@Controller
public class RoleController {

	private RoleRepository roleRepository;
	
	   @Autowired
	    public RoleController(RoleRepository roleRepository) {
	        this.roleRepository = roleRepository;
	    }
	
    @GetMapping("/signupRole")
    public String showSignUpForm(Role role) {
        return "signupRoles_form";
    }
    
    @GetMapping("/roles")
    public String showRolesList(Model model) {
        model.addAttribute("role", roleRepository.findAll());
        return "users";
    }
    
    @PostMapping("/addRole")
    public String addRole(@Valid Role role, BindingResult result, Model model) {
    	System.out.println("ROLE: " + role.getDescription());
        roleRepository.save(role);
        return "redirect:/index";
    }
    
//    @GetMapping("/index")
//    public String showIndex() {
////        model.addAttribute("users", userRepository.findAll());
//        return "index";
//    }
    

    
}
