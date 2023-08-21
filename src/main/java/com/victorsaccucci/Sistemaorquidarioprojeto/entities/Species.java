package com.victorsaccucci.Sistemaorquidarioprojeto.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

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
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;

    public Species(Long id, Long galeryId, String identification, String description, String image) {
        this.id = id;
        this.galeryId = galeryId;
        this.identification = identification;
        this.description = description;
        this.image = image;
    }
    public Species() {
    }
}
