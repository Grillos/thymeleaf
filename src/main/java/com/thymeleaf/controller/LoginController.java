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
public class LoginController {
	
	@Autowired
	UserService UserService;

    @GetMapping
    public String get(Model model) {
    	model.addAttribute("user", new User());
        return "login";
    }
    
    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
    	model.addAttribute("users", UserService.findAll());
        return "users";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "error/access-denied";
    }
    
}
