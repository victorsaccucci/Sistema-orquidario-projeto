package com.victorsaccucci.Sistemaorquidarioprojeto.controllers;

import com.victorsaccucci.Sistemaorquidarioprojeto.entities.Galery;
import com.victorsaccucci.Sistemaorquidarioprojeto.entities.User;
import com.victorsaccucci.Sistemaorquidarioprojeto.services.GaleryService;
import com.victorsaccucci.Sistemaorquidarioprojeto.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class GaleryController {

    @Autowired
    private GaleryService service;

    @PostMapping(value = "/create-gallery")
    public ResponseEntity<String> createGallery(@RequestBody Galery galery, HttpServletRequest request) {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            Long userId = user.getId();
            galery.setUserId(userId);

            service.save(galery);
            return new ResponseEntity<>("{\"titulo\": \"" + galery.getTitle() + "\"}", HttpStatus.CREATED);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }
}
