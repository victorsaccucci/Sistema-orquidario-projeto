package com.victorsaccucci.Sistemaorquidarioprojeto.services;

import com.victorsaccucci.Sistemaorquidarioprojeto.entities.User;
import com.victorsaccucci.Sistemaorquidarioprojeto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User saveUser(User user){
        return userRepository.save(user);
    }

    @Transactional
    public User findById(Long id) {
        User result = userRepository.findById(id).get();
        return result;
    }

    @Transactional
    public ArrayList<User> findAllUsers() {
        ArrayList<User> result = (ArrayList<User>) userRepository.findAll();
        return result;
    }
}
