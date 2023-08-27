package com.victorsaccucci.Sistemaorquidarioprojeto.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Galery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String title;


    public Galery(Long id, Long userId, String title) {
        this.id = id;
        this.userId = userId;
        this.title = title;
    }
    public Galery(){
    }
}
