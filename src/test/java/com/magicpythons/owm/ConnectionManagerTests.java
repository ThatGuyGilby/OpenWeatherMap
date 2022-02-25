package com.magicpythons.owm;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;

public class ConnectionManagerTests {
    private static ConnectionManager connectionManager;
    private static HttpClient httpClient;

    @BeforeAll
    public static void setUp(){
        connectionManager = new ConnectionManager();
        httpClient = HttpClient.newHttpClient();

    }


    @Test
    @DisplayName("Given A valid url String, return a http request")
    public void givenAValidUrlStringReturnHttpRequest() {

        HttpRequest actual = connectionManager.getRequest("https://api.openweathermap.org/data/2.5/weather?q=London&appid=");
        String expected = "https://api.openweathermap.org/data/2.5/weather?q=London&appid=c977119cbca2b2f41098fbaf53a315ae GET";
        Assertions.assertEquals(expected, actual.toString());
    }

    @Test
    @Timeout(5)
    @DisplayName("Given a valid http request and client, return status code 200")
    public void givenRequestAndClientReturnHttpResponseString(){
        HttpRequest httpRequest = connectionManager.getRequest("https://api.openweathermap.org/data/2.5/weather?q=London&appid=");
        HttpResponse<String> actual = connectionManager.getResponse(httpClient, httpRequest);
        System.out.println(actual);
        Assertions.assertTrue(actual.statusCode()>=200 && actual.statusCode()<204);
    }

    @Test
    @Timeout(5)
    @DisplayName("Given a valid http response and key return JSONObject")
    public void givenAValidHttpResponseAndKeyReturnJSONObject(){
        HttpRequest httpRequest = connectionManager.getRequest("https://api.openweathermap.org/data/2.5/weather?q=London&appid=");
        HttpResponse<String> response = connectionManager.getResponse(httpClient,httpRequest);
        JSONObject actual = connectionManager.getResponseAsJSONObject(response, "clouds");
        System.out.println(actual);
        Assertions.assertTrue(actual.containsKey("all"));
    }



    @Test
    @DisplayName("Given a response and key return object")
    public void givenResponseAndKeyReturnObject(){
        HttpRequest httpRequest = connectionManager.getRequest("https://api.openweathermap.org/data/2.5/weather?q=London&appid=");
        HttpResponse<String> response = connectionManager.getResponse(httpClient,httpRequest);
        Object actual = connectionManager.getResponseAsObject(response, "base");
        Assertions.assertTrue(actual.equals("stations"));


    }
    @Test
    @DisplayName("Given a response and key return JSON array (Weather specific")
    public void givenResponseAndKeyReturnJSONArray(){
        HttpRequest httpRequest = connectionManager.getRequest("https://api.openweathermap.org/data/2.5/weather?q=London&appid=");
        HttpResponse<String> response = connectionManager.getResponse(httpClient,httpRequest);
        JSONArray actual = connectionManager.getResponseAsJSONArray(response, "weather");
        Assertions.assertTrue(actual.get(0).toString().contains("id"));
    }


}
