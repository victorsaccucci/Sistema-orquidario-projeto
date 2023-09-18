package com.victorsaccucci.Sistemaorquidarioprojeto.repositories;

import com.victorsaccucci.Sistemaorquidarioprojeto.entities.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.tokens.Token;

import java.util.List;

@Repository
public interface GaleryRepository extends JpaRepository<Gallery, Long>, JpaSpecificationExecutor<Gallery> {
    @Query(value = "SELECT * FROM galery", nativeQuery = true)
    List<Gallery> getAllLists();

    @Query(value = "SELECT * FROM galery WHERE user_id = ?", nativeQuery = true)
    List<Gallery> listAllListsByUserId(Long userId);

    @Query(value = "SELECT image FROM species WHERE galery_id = ?", nativeQuery = true)
    List<byte[]> findImagesByGalleryId(Long galleryId);

   Long deleteGalleryById(Long id);

   @Query(value = "SELECT galery.id FROM galery WHERE galery.title = ?", nativeQuery = true)
    Long getGalleryIdByTitle(String titulo);
}
