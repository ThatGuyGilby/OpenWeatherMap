package com.magicpythons.owm;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.magicpythons.owm.weather.Weather;

import java.io.IOException;
import java.net.URL;
import java.net.http.HttpResponse;

public class Injector {

    public DataTransferObject convertResponseToDTO(HttpResponse response){
        ObjectMapper objectMapper = new ObjectMapper();
        DataTransferObject dto = new DataTransferObject();

        try {
            Weather weather = objectMapper.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=c977119cbca2b2f41098fbaf53a315ae"), Weather.class);
            // TODO - set DTO attributes
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
