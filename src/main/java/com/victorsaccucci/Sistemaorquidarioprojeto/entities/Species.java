package com.victorsaccucci.Sistemaorquidarioprojeto.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
@Getter
@Setter
@Entity
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "galery_id")
    private Galery galery;

    private String identification;
    private String description;
    @Lob
    private byte[] image;

    public Species(Long id, Galery galery, String identification, String description, byte[] image) {
        this.id = id;
        this.galery = galery;
        this.identification = identification;
        this.description = description;
        this.image = image;
    }
    public Species(){
    }
}
