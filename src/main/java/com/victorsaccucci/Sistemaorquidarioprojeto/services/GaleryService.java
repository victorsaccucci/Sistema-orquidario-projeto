package com.victorsaccucci.Sistemaorquidarioprojeto.services;

import com.victorsaccucci.Sistemaorquidarioprojeto.Specification.GallerySpecification;
import com.victorsaccucci.Sistemaorquidarioprojeto.entities.Gallery;
import com.victorsaccucci.Sistemaorquidarioprojeto.repositories.GaleryRepository;
import com.victorsaccucci.Sistemaorquidarioprojeto.selector.GallerySelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GaleryService {

    @Autowired
    private GaleryRepository repository;

    @Transactional
    public Gallery save(Gallery gallery) {
        return repository.save(gallery);
    }
    @Transactional
    public Long deleteGalleryById(Long id){
      return repository.deleteGalleryById(id);
    }

    @Transactional
    public List<Gallery> getGaleriasByUserId(Long userId){
        List<Gallery> userGaleries = repository.listAllListsByUserId(userId);
        return userGaleries;
    }

    @Transactional
    public List<byte[]> findAllImagesByGalleryId(Long id){
        List<byte[]> images = repository.findImagesByGalleryId(id);
        return images;
    }
    public List<Gallery> listWSelector(GallerySelector selector) {
        Specification<Gallery> specification = GallerySpecification.wFilter(selector);
        return repository.findAll(specification);
    }

    public Long getGalleryIdByTitle(String titulo) {
        return repository.getGalleryIdByTitle(titulo);
    }
}
