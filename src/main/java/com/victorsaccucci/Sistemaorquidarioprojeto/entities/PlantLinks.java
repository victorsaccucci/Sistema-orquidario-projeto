package com.victorsaccucci.Sistemaorquidarioprojeto.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlantLinks {
    @JsonProperty("self")
    private String self;

    @JsonProperty("first")
    private String first;

    @JsonProperty("next")
    private String next;

    @JsonProperty("last")
    private String last;

    public PlantLinks(String self, String first, String next, String last) {
        this.self = self;
        this.first = first;
        this.next = next;
        this.last = last;
    }
    public PlantLinks(){

    }
    public String getSelf() {
        return self;
    }

    public String getFirst() {
        return first;
    }

    public String getNext() {
        return next;
    }

    public String getLast() {
        return last;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
