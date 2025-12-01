package com.nekocodes.ai_service.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MealSuggestionResponse {
    private List<MealSuggestion> suggestions;
}
