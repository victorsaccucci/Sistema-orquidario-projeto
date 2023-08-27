package com.victorsaccucci.Sistemaorquidarioprojeto.controllers;

import com.victorsaccucci.Sistemaorquidarioprojeto.entities.Galery;
import com.victorsaccucci.Sistemaorquidarioprojeto.entities.User;
import com.victorsaccucci.Sistemaorquidarioprojeto.services.GaleryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class RestControllerGallery {
    @Autowired
    private GaleryService service;

    @GetMapping(value = "/galleryList")
    public List<Galery> galerias(HttpServletRequest request){

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        Long userId = user.getId();
        List<Galery> userGalery = service.getGaleriasByUserId(userId);

        return userGalery;
    }

    @GetMapping("/galleryImages/{galleryId}")
    public ResponseEntity<List<byte[]>> getGalleryImages(@PathVariable Long galleryId) {
        List<byte[]> images = service.findAllImagesByGalleryId(galleryId);
        return ResponseEntity.ok(images);
    }
}
