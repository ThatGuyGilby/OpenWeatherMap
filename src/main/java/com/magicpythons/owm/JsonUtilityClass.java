package com.magicpythons.owm;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtilityClass {
    private static ObjectMapper objectMapper = getobjectMapper();

    private static ObjectMapper getobjectMapper() {
        ObjectMapper objectMapperToReturn = new ObjectMapper();

        return objectMapperToReturn;
    }

    public static JsonNode parse(String src) throws JsonProcessingException {
        return objectMapper.readTree(src);
    }

    public static DataTransferObject fromJson(JsonNode node) throws JsonProcessingException {
        return objectMapper.treeToValue(node, DataTransferObject.class);
    }
}
