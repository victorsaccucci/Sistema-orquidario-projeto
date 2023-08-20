package com.victorsaccucci.Sistemaorquidarioprojeto.controllers;

import com.victorsaccucci.Sistemaorquidarioprojeto.entities.User;
import com.victorsaccucci.Sistemaorquidarioprojeto.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    // service injetado no cootroller ?
    //existe má pratica em fazer dois tipos de injecoes de dependecias no controller?
    // ex: loginController com autowird userrepository e depois userController com autowird userservice?

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id){
        User result = userService.findById(id);
        return result;
    }

    @GetMapping(value = "/all")
    public ArrayList<User> findAll(){
        ArrayList<User> result = userService.findAllUsers();
        return result;
    }
}
