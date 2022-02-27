package com.magicpythons.owm;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.Properties;

public class ConnectionManager {
    /**
     * A Private Method that holds the access to the api.properties file
     * Intended to allow the use of any API Key inserted in the file
     * without giving away the api key and hosting it on GitHub
     */
    private String getAPIKey() {
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


    /**
     * Method for taking in the API url and returning an HTTP request
     */
    public HttpRequest getRequest(String url) {
        String apiKey = getAPIKey();
        return HttpRequest
                .newBuilder()
                .uri(URI.create(url + apiKey))
                .build();
    }

    /**
     * Method for taking in a client instance and the request made from the url which then returns an HTTP response
     */
    public HttpResponse<String> getResponse(HttpClient client, HttpRequest request) {
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * From the response, this method returns a specific JSON Object
     * based off the key given
     */
    public JSONObject getResponseAsJSONObject(HttpResponse response, String key) {
        try {
            String responseBody = (String) response.body();
            JSONParser jsonParser = new JSONParser();

            JSONObject jsonObject = (JSONObject) jsonParser.parse(responseBody);

            return (JSONObject) jsonObject.get(key);

        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * From the response, this method returns a specific Object value
     * based off the key given
     */
    public Object getResponseAsObject(HttpResponse response, String key) {
        try {
            String responseBody = (String) response.body();
            JSONParser jsonParser = new JSONParser();

            JSONObject jsonObject = (JSONObject) jsonParser.parse(responseBody);

            return jsonObject.get(key);

        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * From the response, this method returns a specific JSON Array
     * based off the key given
     */
    public JSONArray getResponseAsJSONArray(HttpResponse response, String key) {
        try {
            String responseBody = (String) response.body();
            JSONParser jsonParser = new JSONParser();

            JSONObject jsonObject = (JSONObject) jsonParser.parse(responseBody);
            ;
            return (JSONArray) jsonObject.get(key);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
