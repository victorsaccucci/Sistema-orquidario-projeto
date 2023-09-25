package com.victorsaccucci.Sistemaorquidarioprojeto.entities;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlantResponse {

   private List<Plant> data;

    private Links links;

    private Meta meta;

    public PlantResponse(List<Plant> data, Links links, Meta meta) {
        this.data = data;
        this.links = links;
        this.meta = meta;
    }
    public PlantResponse(){
    }

}

