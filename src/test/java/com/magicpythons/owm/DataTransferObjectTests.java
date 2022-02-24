package com.magicpythons.owm;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataTransferObjectTests
{
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
            "  }                         ";

    @Test
    void fromJson()
    {
        try {
            JsonNode node = JsonUtilityClass.parse(testResponse);
            DataTransferObject dataTransferObject = JsonUtilityClass.fromJson(node);

            int expected = 1560343627;
            int actual = dataTransferObject.getSys().getSunrise();

            Assertions.assertEquals(expected, actual);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
