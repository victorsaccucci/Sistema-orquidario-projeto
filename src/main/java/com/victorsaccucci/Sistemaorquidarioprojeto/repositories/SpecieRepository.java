package com.victorsaccucci.Sistemaorquidarioprojeto.repositories;

import com.victorsaccucci.Sistemaorquidarioprojeto.entities.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecieRepository extends JpaRepository<Species, Long> {
}
