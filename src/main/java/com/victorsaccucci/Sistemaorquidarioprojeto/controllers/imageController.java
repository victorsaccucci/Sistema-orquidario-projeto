package com.victorsaccucci.Sistemaorquidarioprojeto.controllers;


import com.victorsaccucci.Sistemaorquidarioprojeto.entities.Gallery;
import com.victorsaccucci.Sistemaorquidarioprojeto.entities.Species;
import com.victorsaccucci.Sistemaorquidarioprojeto.entities.User;
import com.victorsaccucci.Sistemaorquidarioprojeto.services.GaleryService;
import com.victorsaccucci.Sistemaorquidarioprojeto.services.SpecieService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;


@Controller
public class imageController {

    @Autowired
    private SpecieService service;

    @Autowired
    private GaleryService galeryService;



    @GetMapping(value = "/register-Image")
    public String register(Model model, HttpServletRequest request){

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if(user != null){
            Long userId= user.getId();
            List<Gallery> userGaleries = galeryService.getGaleriasByUserId(userId);
            model.addAttribute("userGaleries", userGaleries);
        }
        return "register-Image";
    }


    //TODO change redirect to the galery
    @PostMapping(value = "/register-Image")
    public String registerSpecie(HttpServletRequest request,
                                 @RequestParam("description") String description,
                                 @RequestParam("identification") String identification,
                                 @RequestParam("galeriaId") Long galeriaId,
                                 @RequestParam("image") MultipartFile image) throws SQLException, IOException {

        byte[] bytes = image.getBytes();
        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);

        Species species = new Species();

        species.setImage(blob);
        species.setIdentification(identification);
        species.setDescription(description);
        species.setGaleryId(galeriaId);

        service.save(species);
        return "redirect:/welcome";
    }
}
