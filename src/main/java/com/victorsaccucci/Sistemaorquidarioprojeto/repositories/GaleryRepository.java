package com.victorsaccucci.Sistemaorquidarioprojeto.repositories;

import com.victorsaccucci.Sistemaorquidarioprojeto.entities.Galery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GaleryRepository extends JpaRepository<Galery, Long> {
}
