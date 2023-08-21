package com.victorsaccucci.Sistemaorquidarioprojeto.controllers;


import com.victorsaccucci.Sistemaorquidarioprojeto.entities.Species;
import com.victorsaccucci.Sistemaorquidarioprojeto.services.SpecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class SpecieController {

    @Autowired
    private SpecieService service;

    @GetMapping(value = "/register-Image")
    public String register(){
        return "register-Image";
    }


    //TODO change redirect to the galery
    @PostMapping(value = "/register-Image")
    public String registerSpecie(@RequestParam("description") String description,
                                 @RequestParam("image") MultipartFile image,
                                 @RequestParam("identification") String identification,
                                 @RequestParam("galeryId") Long galeryId) {
        service.save(description, image, identification, galeryId);
        return "redirect:/welcome";
    }
}
