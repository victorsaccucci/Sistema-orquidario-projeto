package com.victorsaccucci.Sistemaorquidarioprojeto.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Meta {
    private Integer total;

    public Meta(Integer total) {
        this.total = total;
    }
    public Meta(){
    }
}
