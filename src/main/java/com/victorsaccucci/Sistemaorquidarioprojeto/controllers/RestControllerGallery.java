package com.victorsaccucci.Sistemaorquidarioprojeto.controllers;

import com.victorsaccucci.Sistemaorquidarioprojeto.entities.Gallery;
import com.victorsaccucci.Sistemaorquidarioprojeto.entities.User;
import com.victorsaccucci.Sistemaorquidarioprojeto.repositories.GaleryRepository;
import com.victorsaccucci.Sistemaorquidarioprojeto.selector.GallerySelector;
import com.victorsaccucci.Sistemaorquidarioprojeto.services.GaleryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.hibernate.Hibernate.map;


@RestController
@RequestMapping(value = "/api")
public class RestControllerGallery {

    @Autowired
    private GaleryService service;

    @Autowired
    private GaleryRepository repository;


    @GetMapping(value = "/galleryList")
    public List<Gallery> galerias(HttpServletRequest request){

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        Long userId = user.getId();
        List<Gallery> userGalery = service.getGaleriasByUserId(userId);

        return userGalery;
    }
    @GetMapping("/galleryImages/{galleryId}")
    public ResponseEntity<List<byte[]>> getGalleryImages(@PathVariable Long galleryId) {
        List<byte[]> images = service.findAllImagesByGalleryId(galleryId);
        return ResponseEntity.ok(images);
    }
    @PostMapping("/filter")
    public List<Gallery> listWSelector(@RequestBody GallerySelector selector, HttpServletRequest request){

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        Long userId = user.getId();
        selector.setUserId(userId);

        return service.listWSelector(selector);
    }
    @DeleteMapping(value = "/delete/{id}")
    public Long deleteGalleryById(@PathVariable Long id){
        return service.deleteGalleryById(id);
    }

    @PutMapping(value = "/update/{id}")
    Gallery updateById(@PathVariable Long id, @RequestBody Gallery newGallery){
      return repository.findById(id)
              .map(gallery -> {
                  gallery.setTitle(newGallery.getTitle());
                  return repository.save(gallery);
              }).orElseGet(()->{
                  newGallery.setId(id);
                  return repository.save(newGallery);
              });
    }
    @GetMapping("/galleryIdByTitle/{titulo}")
    public Long getGalleryIdByTitle(@PathVariable String titulo) {
        return service.getGalleryIdByTitle(titulo);
    }
}
