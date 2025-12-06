package com.nekocodes.ai_service.controller;

import com.nekocodes.ai_service.DTO.MealSuggestionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nekocodes.ai_service.DTO.FormData;
import com.nekocodes.ai_service.service.AiService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class Controller {

    private final AiService aiService;

    @PostMapping("/generate")
    public ResponseEntity<MealSuggestionResponse> generateMealSuggestion(@RequestBody FormData jsonInput) {

        MealSuggestionResponse response = aiService.runLlm(jsonInput);
        log.info("Meal suggestion generated");
        return ResponseEntity.ok().body(response);
    }

}
