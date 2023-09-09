package com.victorsaccucci.Sistemaorquidarioprojeto.controllers;

import com.victorsaccucci.Sistemaorquidarioprojeto.entities.Gallery;
import com.victorsaccucci.Sistemaorquidarioprojeto.entities.User;
import com.victorsaccucci.Sistemaorquidarioprojeto.services.GaleryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GaleryController {

    @Autowired
    private GaleryService service;

    @PostMapping(value = "/create-gallery")
    public ResponseEntity<String> createGallery(@RequestBody Gallery gallery, HttpServletRequest request) {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            Long userId = user.getId();
            gallery.setUserId(userId);

            service.save(gallery);
            return new ResponseEntity<>("{\"titulo\": \"" + gallery.getTitle() + "\"}", HttpStatus.CREATED);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }
    //@DeleteMapping(value = "/delete")

}
