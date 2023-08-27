package com.victorsaccucci.Sistemaorquidarioprojeto.services;

import com.victorsaccucci.Sistemaorquidarioprojeto.entities.Galery;
import com.victorsaccucci.Sistemaorquidarioprojeto.repositories.GaleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GaleryService {

    @Autowired
    private GaleryRepository repository;

    @Transactional
    public Galery save(Galery galery) {
        return repository.save(galery);
    }

    @Transactional
    public List<Galery> getGaleriasByUserId(Long userId){
        List<Galery> userGaleries = repository.listAllListsByUserId(userId);
        return userGaleries;
    }

    @Transactional
    public List<byte[]> findAllImagesByGalleryId(Long id){
        List<byte[]> images = repository.findImagesByGalleryId(id);
        return images;
    }
}
