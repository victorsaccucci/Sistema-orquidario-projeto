package com.victorsaccucci.Sistemaorquidarioprojeto.services;

import com.victorsaccucci.Sistemaorquidarioprojeto.entities.Species;
import com.victorsaccucci.Sistemaorquidarioprojeto.repositories.SpecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class SpecieService {

    @Autowired
    private SpecieRepository repository;


    @Transactional
    public Species save(String description, MultipartFile image, String identification, Long galeryId) {

        Species species = new Species();
        species.setDescription(description);
        species.setIdentification(identification);
        species.setGaleryId(galeryId);
        species.setImage(String.valueOf(image));

        return repository.save(species);
    }
}
