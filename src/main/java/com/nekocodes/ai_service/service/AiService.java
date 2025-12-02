package com.nekocodes.ai_service.service;

import com.nekocodes.ai_service.DTO.MealSuggestionResponse;
import com.nekocodes.ai_service.util.MealSuggestionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.nekocodes.ai_service.DTO.FormData;
import com.nekocodes.ai_service.util.PromptBuilder;

import dev.langchain4j.model.chat.ChatLanguageModel;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Slf4j
public class AiService {

    private final ChatLanguageModel model;
    private final PromptBuilder promptBuilder;

    public MealSuggestionResponse runLlm(FormData formData) {
        log.info("FormData: {}", formData.toString());
        String prompt = promptBuilder.buildMealSuggestionPrompt(formData);
        log.debug("Prompt: {}", prompt);
        log.info("Running Prompt...");
        String responseText = model.generate(prompt);
        return MealSuggestionMapper.mapPromptResponseToDTO(responseText);
    }

}
