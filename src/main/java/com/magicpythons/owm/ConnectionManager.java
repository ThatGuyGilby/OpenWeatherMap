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
    // !!!Placeholder main for testing purposes only, remove when getRequest method is accessed from elsewhere!!!
    public static void main(String[] args) {
        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.getRequest("https://api.openweathermap.org/data/2.5/weather?q=London&appid=");
    }



    /* A Private Method that holds the access to the api.properties file
    *  Intended to allow the use of any API Key inserted in the file
    *  without giving away the api key and hosting it on GitHub */
    private String getAPIKey(){
        String apiKey = null;
        try (InputStream inputStream = new FileInputStream("src/main/resources/api.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);

            apiKey = properties.getProperty("api_key");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return apiKey; // Returns the API Key found in the api.properties file
    }

//    public void getWeather(){
//          While commented out, this could provide useful in the future
//    }

    
    public Weather getRequest(String url){
        ObjectMapper objectMapper = new ObjectMapper();
        String apiKey = getAPIKey(); // Acquires the API Key
        Weather myObj = null;

        try {
            myObj = objectMapper.readValue(new URL(url + apiKey), Weather.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return myObj;
    }


    /* For future reference, this splits the data apart into their Jackson related file formats

    private void getJSONArray(Weather weather){
        Clouds clouds = weather.getClouds();
        Coord coord = weather.getCoord();
        Main main = weather.getMain();
        Sys sys = weather.getSys();
        List<WeatherItem> weather1 = weather.getWeather();
        Wind wind = weather.getWind();

        System.out.println(clouds + "\n"
                + coord + "\n"
                + main + "\n"
                + sys + "\n"
                + weather1 + "\n"
                + wind);
    }
    */
}
