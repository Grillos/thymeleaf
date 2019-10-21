package com.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.thymeleaf.domain.User;
import com.thymeleaf.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;

    @GetMapping("/users")
    public String get(Model model) {
    	model.addAttribute("user", new User());
        return "users";
    }
    
    @GetMapping("/users-list")
    public String list(Model model) {
    	model.addAttribute("users", userService.findAll());
    	model.addAttribute("user", new User());
        return "list-users";
    }
    
    @PostMapping("/users")
    public String save(@ModelAttribute User user, Model model) {
    	userService.save(user);
    	model.addAttribute("users", userService.findAll());
        return "list-users";
    }
}
