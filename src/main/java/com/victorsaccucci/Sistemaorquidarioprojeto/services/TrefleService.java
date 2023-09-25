package com.victorsaccucci.Sistemaorquidarioprojeto.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.victorsaccucci.Sistemaorquidarioprojeto.apiconfig.TrefleConfig;
import com.victorsaccucci.Sistemaorquidarioprojeto.entities.PlantResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TrefleService {

    private final String apiKey;

    @Autowired
    public TrefleService(TrefleConfig trefleConfig) {
        this.apiKey = trefleConfig.trefleApiKey();
    }
    private final String baseUrl = "https://trefle.io/api/v1/plants/search";

    public PlantResponse searchPlantByName(String plantName) {
        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(baseUrl + "?token=" + apiKey + "&q=" + plantName);
            HttpResponse response = httpClient.execute(request);

            if (response.getStatusLine().getStatusCode() == 200) {
                String jsonResponse = EntityUtils.toString(response.getEntity());

                ObjectMapper objectMapper = new ObjectMapper();
                PlantResponse plantResponse = objectMapper.readValue(jsonResponse, PlantResponse.class);

                return plantResponse;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
