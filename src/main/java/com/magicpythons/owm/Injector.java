package com.magicpythons.owm;

import io.cucumber.java.bs.I;
import io.cucumber.java.eo.Do;
import io.cucumber.java.sl.In;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Injector {

    /**
     * By utilising the HTTP response, it used the methods below and connection manager methods to instantiate and construct
     * a Data Transfer Object and returns its
     */
    public DataTransferObject convertResponseToDTO(ConnectionManager connectionManager, HttpResponse<String> response) {
        DataTransferObject dto = new DataTransferObject();

        insertWind(dto, connectionManager, response);
        insertCoord(dto, connectionManager, response);
        insertWeather(dto, connectionManager, response);
        insertBase(dto, connectionManager, response);
        insertMain(dto, connectionManager, response);
        insertVisibility(dto,connectionManager, response);
        insertClouds(dto,connectionManager, response);
        insertDt(dto,connectionManager, response);
        insertSys(dto,connectionManager, response);
        insertTimezone(dto,connectionManager, response);
        insertId(dto,connectionManager, response);
        insertName(dto,connectionManager, response);
        insertCod(dto,connectionManager, response);

        return dto;
    }

    public static void insertCoord(DataTransferObject dto, ConnectionManager connectionManager, HttpResponse<String> response) {
        JSONObject coordObject = connectionManager.getResponseAsJSONObject(response, "coord");

        Coord coord = new Coord();

        coord.setLon((Double) coordObject.get("lon"));
        coord.setLat((Double) coordObject.get("lat"));
        dto.setCoord(coord);
    }

    public static void insertWeather(DataTransferObject dto, ConnectionManager connectionManager, HttpResponse<String> response) {
        JSONArray weatherArray = connectionManager.getResponseAsJSONArray(response, "weather");
        List<Weather> weatherList = new ArrayList<>();

        for (int i = 0; i < weatherArray.size(); i++) {
            JSONObject weatherObject = (JSONObject) weatherArray.get(i);
            Weather weather = new Weather();

            weather.setId(Integer.valueOf(weatherObject.get("id").toString()));
            weather.setMain((String) weatherObject.get("main"));
            weather.setDescription((String) weatherObject.get("description"));
            weather.setIcon((String) weatherObject.get("icon"));

            weatherList.add(weather);
        }
        dto.setWeather(weatherList);
    }

    // Methods below sets the attributes of the DTO passed in through the methods in connection manager

    public static void insertBase(DataTransferObject dto, ConnectionManager connectionManager, HttpResponse<String> response) {
        Object baseObject = connectionManager.getResponseAsObject(response, "base");

        dto.setBase(baseObject.toString());
    }

    public static void insertMain(DataTransferObject dto, ConnectionManager connectionManager, HttpResponse<String> response) {
        JSONObject mainObject = connectionManager.getResponseAsJSONObject(response, "main");

        Main main = new Main();

        main.setTemp((Double) mainObject.get("temp"));
        main.setFeelsLike((Double) mainObject.get("feels_like"));
        main.setTempMin((Double) mainObject.get("temp_min"));
        main.setTempMax((Double) mainObject.get("temp_max"));
        main.setPressure(Integer.valueOf(mainObject.get("pressure").toString()));
        main.setHumidity(Integer.valueOf(mainObject.get("humidity").toString()));
        dto.setMain(main);
    }

    public static void insertVisibility(DataTransferObject dto, ConnectionManager connectionManager, HttpResponse<String> response) {
        Object visiObject = connectionManager.getResponseAsObject(response, "visibility");

        dto.setVisibility(Integer.valueOf(visiObject.toString()));
    }

    public static void insertWind(DataTransferObject dto, ConnectionManager connectionManager, HttpResponse<String> response) {
        JSONObject windObject = connectionManager.getResponseAsJSONObject(response, "wind");

        Wind wind = new Wind();

        wind.setSpeed((Double) windObject.get("speed"));
        wind.setDeg((Integer.valueOf(windObject.get("deg").toString())));
        dto.setWind(wind);
    }

    public static void insertClouds(DataTransferObject dto, ConnectionManager connectionManager, HttpResponse<String> response) {
        JSONObject cloudObject = connectionManager.getResponseAsJSONObject(response, "clouds");

        Clouds clouds = new Clouds();

        clouds.setAll(Integer.valueOf(cloudObject.get("all").toString()));
        dto.setClouds(clouds);
    }

    public static void insertDt(DataTransferObject dto, ConnectionManager connectionManager, HttpResponse<String> response) {
        Object dtObject = connectionManager.getResponseAsObject(response, "dt");

        dto.setDt(Integer.valueOf(dtObject.toString()));
    }

    public static void insertSys(DataTransferObject dto, ConnectionManager connectionManager, HttpResponse<String> response) {
        JSONObject sysObject = connectionManager.getResponseAsJSONObject(response, "sys");

        Sys sys = new Sys();

        sys.setType(Integer.valueOf(sysObject.get("type").toString()));
        sys.setId(Integer.valueOf(sysObject.get("id").toString()));
        sys.setMessage((Double) sysObject.get("message"));
        sys.setCountry((String) sysObject.get("country"));
        sys.setSunrise(Integer.valueOf(sysObject.get("sunrise").toString()));
        sys.setSunset(Integer.valueOf(sysObject.get("sunset").toString()));
        dto.setSys(sys);
    }

    public static void insertTimezone(DataTransferObject dto, ConnectionManager connectionManager, HttpResponse<String> response) {
        Object timezoneObject = connectionManager.getResponseAsObject(response, "timezone");

        dto.setTimezone(Integer.valueOf(timezoneObject.toString()));
    }

    public static void insertId(DataTransferObject dto, ConnectionManager connectionManager, HttpResponse<String> response) {
        Object idObject = connectionManager.getResponseAsObject(response, "id");

        dto.setId(Integer.valueOf(idObject.toString()));
    }

    public static void insertName(DataTransferObject dto, ConnectionManager connectionManager, HttpResponse<String> response) {
        Object nameObject = connectionManager.getResponseAsObject(response, "name");

        dto.setName(nameObject.toString());
    }

    public static void insertCod(DataTransferObject dto, ConnectionManager connectionManager, HttpResponse<String> response) {
        Object codObject = connectionManager.getResponseAsObject(response, "cod");

        dto.setCod(Integer.valueOf(codObject.toString()));
    }
}
