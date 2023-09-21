package com.victorsaccucci.Sistemaorquidarioprojeto.entities;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Plant {
    @JsonProperty("author")
    private String author;

    @JsonProperty("bibliography")
    private String bibliography;

    @JsonProperty("common_name")
    private String commonName;

    @JsonProperty("family")
    private String family;

    @JsonProperty("family_common_name")
    private String familyCommonName;

    @JsonProperty("genus")
    private String genus;

    @JsonProperty("genus_id")
    private Integer genusId;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("rank")
    private String rank;

    @JsonProperty("scientific_name")
    private String scientificName;

    @JsonProperty("slug")
    private String slug;

    @JsonProperty("status")
    private String status;

    @JsonProperty("year")
    private Integer year;

    @JsonProperty("links")
    private PlantLinks links;

    public Plant(String author, String bibliography,
                 String commonName,
                 String family,
                 String familyCommonName,
                 String genus,
                 Integer genusId,
                 Integer id,
                 Integer year,
                 String rank, String scientificName, String slug, String status, PlantLinks links) {
        this.author = author;
        this.bibliography = bibliography;
        this.commonName = commonName;
        this.family = family;
        this.familyCommonName = familyCommonName;
        this.genus = genus;
        this.genusId = genusId;
        this.id = id;
        this.rank = rank;
        this.scientificName = scientificName;
        this.slug = slug;
        this.status = status;
        this.year = year;
        this.links = links;
    }

    public Plant(){
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBibliography(String bibliography) {
        this.bibliography = bibliography;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setFamilyCommonName(String familyCommonName) {
        this.familyCommonName = familyCommonName;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public void setGenusId(Integer genusId) {
        this.genusId = genusId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public String getBibliography() {
        return bibliography;
    }

    public String getCommonName() {
        return commonName;
    }

    public String getFamily() {
        return family;
    }

    public String getFamilyCommonName() {
        return familyCommonName;
    }

    public String getGenus() {
        return genus;
    }

    public Integer getGenusId() {
        return genusId;
    }

    public Integer getId() {
        return id;
    }

    public String getRank() {
        return rank;
    }

    public String getScientificName() {
        return scientificName;
    }

    public String getSlug() {
        return slug;
    }

    public String getStatus() {
        return status;
    }


    public Integer getYear() {
        return year;
    }

    public void setLinks(PlantLinks links) {
        this.links = links;
    }

    public PlantLinks getLinks() {
        return links;
    }
}
