package com.magicpythons.owm;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.magicpythons.owm.weather.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectionManager
{
    public static void main(String[] args) {
        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.getRequest("https://api.openweathermap.org/data/2.5/weather?q=London&appid=");
    }


    ObjectMapper objectMapper = new ObjectMapper();

    private String getAPIKey(){
        String apiKey = null;
        try (InputStream inputStream = new FileInputStream("src/main/resources/api.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);

            apiKey = properties.getProperty("api_key");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return apiKey;
    }

//    public void getWeather(){
//
//    }

    public void getRequest(String url){
        String apiKey = getAPIKey();
        Weather myObj = null;

        try {
            myObj = objectMapper.readValue(new URL(url + apiKey), Weather.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (myObj != null){
            getJSONArray(myObj);
        }
    }

//    public void getResponse(HttpRequest request){
//
//    }
//
    public void getJSONArray(Weather weather){
        Clouds clouds = weather.getClouds();
        Coord coord = weather.getCoord();
        Main main = weather.getMain();
        Sys sys = weather.getSys();
        List<WeatherItem> weather1 = weather.getWeather();
        Wind wind = weather.getWind();

        System.out.println(clouds + "\n" + coord + "\n" + main + "\n" + sys + "\n" + weather1 + "\n" + wind);


    }
}
