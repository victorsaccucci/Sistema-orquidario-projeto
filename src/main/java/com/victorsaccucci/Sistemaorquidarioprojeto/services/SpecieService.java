package com.victorsaccucci.Sistemaorquidarioprojeto.services;

import com.victorsaccucci.Sistemaorquidarioprojeto.entities.Galery;
import com.victorsaccucci.Sistemaorquidarioprojeto.entities.Species;
import com.victorsaccucci.Sistemaorquidarioprojeto.repositories.GaleryRepository;
import com.victorsaccucci.Sistemaorquidarioprojeto.repositories.SpecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class SpecieService {

    @Autowired
    private SpecieRepository repository;

    @Autowired
    private GaleryRepository galeryRepository;

    @Transactional
    public List<Galery> listAllGalerys(){
        List<Galery> galerys = galeryRepository.getAllLists();
        return galerys;
    }

    public Species save(Species species){
        return repository.save(species);
    }


//    @Transactional
//    public Species save(String description, MultipartFile image, String identification, Long galeryId)  {
//        Species species = new Species();
//        species.setDescription(description);
//        species.setIdentification(identification);
//        species.setGaleryId(galeryId);
//
//        return repository.save(species);
//    }

}
