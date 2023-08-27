package com.victorsaccucci.Sistemaorquidarioprojeto.controllers;


import com.victorsaccucci.Sistemaorquidarioprojeto.entities.Galery;
import com.victorsaccucci.Sistemaorquidarioprojeto.entities.User;
import com.victorsaccucci.Sistemaorquidarioprojeto.repositories.UserRepository;
import com.victorsaccucci.Sistemaorquidarioprojeto.services.GaleryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class  LoginController {

    //chamar o service futuramente.
    @Autowired
    private UserRepository repository;

    @Autowired
    private GaleryService service;

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }


    @PostMapping(value = "/login")
    public String loginUser(@ModelAttribute User userParam, HttpServletRequest request){
        User data = this.repository.Login(userParam.getEmail(), userParam.getPassword());

        if(data != null){
            HttpSession session = request.getSession();
            session.setAttribute("user", data);
            User user = (User) session.getAttribute("user");
            Long userId = user.getId();

            System.out.print("--------------ID DO USUARIO LOGADO:--------------" + userId + service.getGaleriasByUserId(userId));
            return "redirect:/welcome";
        }
        return "login";

    }



    @GetMapping(value = "/welcome")
    public String welcome() {
        return "welcome";
    }
}
