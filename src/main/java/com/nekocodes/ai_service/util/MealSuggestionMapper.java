package com.nekocodes.ai_service.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nekocodes.ai_service.DTO.MealSuggestionResponse;

public class MealSuggestionMapper {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static MealSuggestionResponse mapPromptResponseToDTO(String response) {
        try {
            return objectMapper.readValue(response, MealSuggestionResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error occurred while mapping", e);
        }
    }
}