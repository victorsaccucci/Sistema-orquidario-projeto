package com.victorsaccucci.Sistemaorquidarioprojeto.controllers;

import com.victorsaccucci.Sistemaorquidarioprojeto.entities.Plant;
import com.victorsaccucci.Sistemaorquidarioprojeto.repositories.TrefleService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TrefleController {

    private final TrefleService trefleService;

    public TrefleController(TrefleService trefleService) {
        this.trefleService = trefleService;
    }

    @GetMapping(value = "/search")
    public ResponseEntity<String> searchPlantByName(@RequestParam(value = "plantName", required = false) String plantName) {
        if (plantName == null || plantName.isEmpty()) {
            return ResponseEntity.badRequest().body("O parâmetro 'plantName' está vazio ou nulo.");
        } else {
            String plantData = trefleService.searchPlantByName(plantName);
            if (plantData != null) {
                // Defina o cabeçalho de tipo de conteúdo para JSON
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return new ResponseEntity<>(plantData, headers, HttpStatus.OK);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao buscar os dados da planta.");
            }
        }
    }

}
