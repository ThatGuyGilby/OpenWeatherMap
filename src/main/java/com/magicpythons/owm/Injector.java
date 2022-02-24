package com.magicpythons.owm;

import io.cucumber.messages.JSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.net.http.HttpResponse;

public class Injector {

    public void convertResponseToDTO(ConnectionManager connectionManager, HttpResponse<String> response){
        DataTransferObject dto = new DataTransferObject();

        JSONArray winds = connectionManager.getResponseAsJSONArray(response, "wind");
        JSONObject jsonObject = (JSONObject) winds.get(0);

        Wind wind = new Wind();

        wind.setSpeed((Double) jsonObject.get("speed"));
        wind.setDeg((Integer) jsonObject.get("deg"));
        dto.setWind(wind);

        // System.out.println(winds.get(0));
        // System.out.println(winds.get(1));
    }
}
