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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String title;
    private String subtitle;

    public Galery(Long id, User user, String title, String subtitle) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.subtitle = subtitle;
    }
    public Galery(){
    }
}
