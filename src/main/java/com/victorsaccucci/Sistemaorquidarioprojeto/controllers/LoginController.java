package com.victorsaccucci.Sistemaorquidarioprojeto.controllers;

import com.victorsaccucci.Sistemaorquidarioprojeto.entities.User;
import com.victorsaccucci.Sistemaorquidarioprojeto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserRepository repository;

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @PostMapping(value = "/login")
    public String welcomePage(@ModelAttribute User userParam){
        User data = this.repository.Login(userParam.getEmail(), userParam.getPassword());
        if(data != null){
            return "redirect:/welcome";
        }
        return "login";
    }

    @GetMapping(value = "/welcome")
    public String welcome() {
        return "welcome";
    }
}
