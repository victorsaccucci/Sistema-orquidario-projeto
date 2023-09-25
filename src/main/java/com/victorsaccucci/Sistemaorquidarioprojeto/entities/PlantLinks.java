package com.victorsaccucci.Sistemaorquidarioprojeto.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlantLinks {

    @JsonProperty("self")
    private String self;

    @JsonProperty("plant")
    private String plant;

    @JsonProperty("genus")
    private String genus;

    public PlantLinks(String plant, String self, String genus) {
        this.plant = plant;
        this.self = self;
        this.genus = genus;
    }

    public PlantLinks(){

    }
}
