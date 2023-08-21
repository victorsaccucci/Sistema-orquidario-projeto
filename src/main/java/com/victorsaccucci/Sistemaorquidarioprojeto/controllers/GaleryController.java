package com.victorsaccucci.Sistemaorquidarioprojeto.controllers;

import com.victorsaccucci.Sistemaorquidarioprojeto.services.GaleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class GaleryController {

    @Autowired
    private GaleryService service;

    @PostMapping(value = "/create-gallery")
    @ResponseBody
    public Map<String, Long> createGallery() {

        Long galleryId = service.createGalleryForCurrentUser();
        Map<String, Long> response = new HashMap<>();

        response.put("galleryId", galleryId);
        return response;
    }
}
