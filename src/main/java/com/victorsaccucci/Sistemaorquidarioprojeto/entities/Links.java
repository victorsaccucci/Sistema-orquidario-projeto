package com.victorsaccucci.Sistemaorquidarioprojeto.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Links {

    private String self;
    private String first;
    private String next;
    private String last;

    public Links(String self, String first, String next, String last) {
        this.self = self;
        this.first = first;
        this.next = next;
        this.last = last;
    }
    public Links(){
    }
}
