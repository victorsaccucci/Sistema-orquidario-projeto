package com.victorsaccucci.Sistemaorquidarioprojeto.controllers;

import com.victorsaccucci.Sistemaorquidarioprojeto.entities.User;
import com.victorsaccucci.Sistemaorquidarioprojeto.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public void saveUser(@RequestBody User data){
      userService.saveUser(data);
    }

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
