package com.magicpythons.owm;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherMainClass {
    public static void main(String[] args) {
        ConnectionManager connectionManager = new ConnectionManager();
        HttpRequest httpRequest = connectionManager.getRequest("https://api.openweathermap.org/data/2.5/weather?q=London&appid=");
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> httpResponse = connectionManager.getResponse(httpClient, httpRequest);

        
    }
}
