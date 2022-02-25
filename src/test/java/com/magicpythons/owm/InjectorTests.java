package com.magicpythons.owm;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;

import java.net.http.HttpResponse;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class InjectorTests {

    private String testResponse = "{\n" +
            "  \"coord\": {\n" +
            "    \"lon\": -122.08,\n" +
            "    \"lat\": 37.39\n" +
            "  },\n" +
            "  \"weather\": [\n" +
            "    {\n" +
            "      \"id\": 800,\n" +
            "      \"main\": \"Clear\",\n" +
            "      \"description\": \"clear sky\",\n" +
            "      \"icon\": \"01d\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"base\": \"stations\",\n" +
            "  \"main\": {\n" +
            "    \"temp\": 282.55,\n" +
            "    \"feels_like\": 281.86,\n" +
            "    \"temp_min\": 280.37,\n" +
            "    \"temp_max\": 284.26,\n" +
            "    \"pressure\": 1023,\n" +
            "    \"humidity\": 100\n" +
            "  },\n" +
            "  \"visibility\": 16093,\n" +
            "  \"wind\": {\n" +
            "    \"speed\": 1.5,\n" +
            "    \"deg\": 350\n" +
            "  },\n" +
            "  \"clouds\": {\n" +
            "    \"all\": 1\n" +
            "  },\n" +
            "  \"dt\": 1560350645,\n" +
            "  \"sys\": {\n" +
            "    \"type\": 1,\n" +
            "    \"id\": 5122,\n" +
            "    \"message\": 0.0139,\n" +
            "    \"country\": \"US\",\n" +
            "    \"sunrise\": 1560343627,\n" +
            "    \"sunset\": 1560396563\n" +
            "  },\n" +
            "  \"timezone\": -25200,\n" +
            "  \"id\": 420006353,\n" +
            "  \"name\": \"Mountain View\",\n" +
            "  \"cod\": 200\n" +
            "  }                ";

    private ConnectionManager connectionManager;
    private HttpResponse httpResponseMock;
    private Injector injector;

    @Before
    public void setUp() {
        httpResponseMock = Mockito.mock(HttpResponse.class);
        connectionManager = new ConnectionManager();
        injector = new Injector();
    }

    @Test
    @DisplayName("Testing converting the complete http response to DTO object")
    public void testConvertResponseToDTO() {
        HttpResponse httpResponse = getMockedHTTPResponse(testResponse);
        DataTransferObject dataTransferObject = injector.convertResponseToDTO(connectionManager, httpResponse);

        // asserting coords
        assertEquals(String.valueOf(-122.08), String.valueOf(dataTransferObject.getCoord().getLon()));
        assertEquals(String.valueOf(37.39), String.valueOf(dataTransferObject.getCoord().getLat()));

        // asserting weather
        List<Weather> weathers = dataTransferObject.getWeather();
        assertEquals(1, weathers.size());
        Weather weather = weathers.get(0);
        assertEquals(String.valueOf(800), String.valueOf(weather.getId()));
        assertEquals("Clear", String.valueOf(weather.getMain()));
        assertEquals("01d", String.valueOf(weather.getIcon()));
        assertEquals("clear sky", String.valueOf(weather.getDescription()));

        // asserting base
        assertEquals("stations", String.valueOf(dataTransferObject.getBase()));

        // asserting main
        assertEquals(String.valueOf(282.55), String.valueOf(dataTransferObject.getMain().getTemp()));
        assertEquals(String.valueOf(281.86), String.valueOf(dataTransferObject.getMain().getFeelsLike()));
        assertEquals(String.valueOf(280.37), String.valueOf(dataTransferObject.getMain().getTempMin()));
        assertEquals(String.valueOf(284.26), String.valueOf(dataTransferObject.getMain().getTempMax()));
        assertEquals(String.valueOf(1023), String.valueOf(dataTransferObject.getMain().getPressure()));
        assertEquals(String.valueOf(100), String.valueOf(dataTransferObject.getMain().getHumidity()));

        // asserting visibility
        assertEquals(String.valueOf(16093), String.valueOf(dataTransferObject.getVisibility()));

        // asserting wind
        assertEquals(String.valueOf(1.5), String.valueOf(dataTransferObject.getWind().getSpeed()));
        assertEquals(String.valueOf(350), String.valueOf(dataTransferObject.getWind().getDeg()));

        // asserting clouds
        assertEquals(String.valueOf(1), String.valueOf(dataTransferObject.getClouds().getAll()));

        //asserting dt
        assertEquals(String.valueOf(1560350645), String.valueOf(dataTransferObject.getDt()));

        // asserting sys
        assertEquals(String.valueOf(1), String.valueOf(dataTransferObject.getSys().getType()));
        assertEquals(String.valueOf(5122), String.valueOf(dataTransferObject.getSys().getId()));
        assertEquals(String.valueOf(0.0139), String.valueOf(dataTransferObject.getSys().getMessage()));
        assertEquals("US", String.valueOf(dataTransferObject.getSys().getCountry()));
        assertEquals(String.valueOf(1560343627), String.valueOf(dataTransferObject.getSys().getSunrise()));
        assertEquals(String.valueOf(1560396563), String.valueOf(dataTransferObject.getSys().getSunset()));

        // asserting timezone
        assertEquals(String.valueOf(-25200), String.valueOf(dataTransferObject.getTimezone()));

        // asserting id
        assertEquals(String.valueOf(420006353), String.valueOf(dataTransferObject.getId()));

        // asserting name
        assertEquals("Mountain View", String.valueOf(dataTransferObject.getName()));

        // assert cod
        assertEquals(String.valueOf(200), String.valueOf(dataTransferObject.getCod()));
    }

    @Test
    @DisplayName("Testing converting the specific node{coord} from http response to DTO object")
    public void testInsertCoordResponseToDTO() {
        String testCordResponse = "{\n" +
                "  \"coord\": {\n" +
                "    \"lon\": -100.08,\n" +
                "    \"lat\": 47.39\n" +
                "  } }";
        HttpResponse httpResponse = getMockedHTTPResponse(testCordResponse);
        DataTransferObject dataTransferObject = new DataTransferObject();
        Injector.insertCoord(dataTransferObject, connectionManager, httpResponse);

        // asserting coords
        assertEquals(String.valueOf(-100.08), String.valueOf(dataTransferObject.getCoord().getLon()));
        assertEquals(String.valueOf(47.39), String.valueOf(dataTransferObject.getCoord().getLat()));
    }

    private HttpResponse getMockedHTTPResponse(String responseBody) {
        Mockito.when(httpResponseMock.statusCode()).thenReturn(200);
        Mockito.when(httpResponseMock.body()).thenReturn(responseBody);
        return httpResponseMock;
    }
}
