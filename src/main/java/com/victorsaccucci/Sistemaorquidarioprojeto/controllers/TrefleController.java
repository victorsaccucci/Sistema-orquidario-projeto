package com.victorsaccucci.Sistemaorquidarioprojeto.controllers;


import com.victorsaccucci.Sistemaorquidarioprojeto.entities.Plant;
import com.victorsaccucci.Sistemaorquidarioprojeto.entities.PlantResponse;
import com.victorsaccucci.Sistemaorquidarioprojeto.services.TrefleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class TrefleController {

    @Autowired
    private TrefleService trefleService;

    public TrefleController(TrefleService trefleService) {
        this.trefleService = trefleService;
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Plant>> searchPlantByName(@RequestParam(value = "plantName", required = false) String plantName) {
        if (plantName == null || plantName.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        } else {
            PlantResponse plantResponse = trefleService.searchPlantByName(plantName);
            if (plantResponse != null && plantResponse.getData() != null) {
                List<Plant> plants = plantResponse.getData();
                if (!plants.isEmpty()) {
                    return ResponseEntity.ok(plants);
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
                }
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        }
    }
}
