package com.victorsaccucci.Sistemaorquidarioprojeto.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Blob;

@Entity
@Getter
@Setter
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long galeryId;
    private String identification;
    private String description;

    @Lob
    private Blob image;

    public Species(Long id, Long galeryId, String identification, String description, Blob image) {
        this.id = id;
        this.galeryId = galeryId;
        this.identification = identification;
        this.description = description;
        this.image = image;
    }
    public Species() {
    }
}
