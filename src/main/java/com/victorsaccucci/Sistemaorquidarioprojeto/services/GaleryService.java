package com.victorsaccucci.Sistemaorquidarioprojeto.services;

import com.victorsaccucci.Sistemaorquidarioprojeto.entities.Galery;
import com.victorsaccucci.Sistemaorquidarioprojeto.repositories.GaleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GaleryService {

    @Autowired
    private GaleryRepository repository;

    @Transactional
    public Long createGalleryForCurrentUser() {

        Galery galery = new Galery();
        Galery savedGallery = repository.save(galery);
        return savedGallery.getId();
    }
}
