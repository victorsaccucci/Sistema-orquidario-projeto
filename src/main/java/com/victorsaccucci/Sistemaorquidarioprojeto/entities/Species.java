package com.victorsaccucci.Sistemaorquidarioprojeto.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long galeryId;
    private String identification;
    private String description;
    @Lob
    private byte[] image;

    public Species(Long id, Long galeryId, String identification, String description, byte[] image) {
        this.id = id;
        this.galeryId = galeryId;
        this.identification = identification;
        this.description = description;
        this.image = image;
    }
    public Species(){
    }
}
