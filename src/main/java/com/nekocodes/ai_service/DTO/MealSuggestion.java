package com.nekocodes.ai_service.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MealSuggestion {
    private int id;
    private String name;
    private String type;
    private String cookTime;
    private int servings;
    private List<String> ingredients;
    private String difficulty;
}
