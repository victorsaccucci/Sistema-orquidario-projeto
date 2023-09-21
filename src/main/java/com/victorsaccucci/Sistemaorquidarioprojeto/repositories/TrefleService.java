package com.victorsaccucci.Sistemaorquidarioprojeto.repositories;

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
    private final String baseUrl = "https://trefle.io/api/v1/plants";

    //url: https://trefle.io/api/v1/plants/search?token=8DjJYyPkM2B-oAe5mGPaPAEv44ep8MQjneGsRYheybQ&q=cattleya

    @Autowired
    public TrefleService(String trefleApiKey) {
        this.apiKey = trefleApiKey;
    }

    public String searchPlantByName(String plantName) {
        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(baseUrl + "?token=" + apiKey + "&q=" + plantName);
            HttpResponse response = httpClient.execute(request);

            if (response.getStatusLine().getStatusCode() == 200) {
                return EntityUtils.toString(response.getEntity());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
