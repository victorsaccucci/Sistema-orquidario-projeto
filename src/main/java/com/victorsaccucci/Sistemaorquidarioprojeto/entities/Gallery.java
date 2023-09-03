package com.victorsaccucci.Sistemaorquidarioprojeto.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "galery")
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String title;


    public Gallery(Long id, Long userId, String title) {
        this.id = id;
        this.userId = userId;
        this.title = title;
    }
    public Gallery(){
    }
}
