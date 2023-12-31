package com.victorsaccucci.Sistemaorquidarioprojeto.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Setter
@Getter
public class Plant {

    private Integer id;
    @JsonProperty("common_name")
    private String commonName;
    private String slug;
    @JsonProperty("scientific_name")
    private String scientificName;
    private Integer year;
    private String bibliography;
    private String author;
    private String status;
    private String rank;
    @JsonProperty("family_common_name")
    private String familyCommonName;
    @JsonProperty("genus_id")
    private Integer genusId;
    private String genus;
    private String family;
    private PlantLinks links;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("synonyms")
    private List<String> synonyms;


    public Plant(Integer id, String commonName, String slug, String scientificName, Integer year, String bibliography, String author, String status, String rank, String familyCommonName, Integer genusId, String genus, String family, PlantLinks links, String imageUrl, List<String> synonyms) {
        this.id = id;
        this.commonName = commonName;
        this.slug = slug;
        this.scientificName = scientificName;
        this.year = year;
        this.bibliography = bibliography;
        this.author = author;
        this.status = status;
        this.rank = rank;
        this.familyCommonName = familyCommonName;
        this.genusId = genusId;
        this.genus = genus;
        this.family = family;
        this.links = links;
        this.imageUrl = imageUrl;
        this.synonyms= synonyms;
    }

    public Plant(){
    }

}
