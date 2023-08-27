package com.victorsaccucci.Sistemaorquidarioprojeto.repositories;

import com.victorsaccucci.Sistemaorquidarioprojeto.entities.Galery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GaleryRepository extends JpaRepository<Galery, Long> {

    @Query(value = "SELECT * FROM galery", nativeQuery = true)
    List<Galery> getAllLists();

    @Query(value = "SELECT * FROM galery WHERE user_id = ?", nativeQuery = true)
    List<Galery> listAllListsByUserId(Long userId);

    @Query(value = "SELECT image FROM species WHERE galery_id = ?", nativeQuery = true)
    List<byte[]> findImagesByGalleryId(Long galleryId);

}
