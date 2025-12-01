package com.nekocodes.ai_service.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;

@Configuration
public class ModelConfig {

    @Value("${openai.api.key}")
    private String openAiApiKey;

    @Value("${openai.model.name:gpt-4.1-mini}")
    private String openAiModelName;

    @Bean
    public ChatLanguageModel chatLanguageModel() {

        return OpenAiChatModel.builder()
                .apiKey(openAiApiKey)
                .modelName(openAiModelName)
                .temperature(0.2)
                .timeout(Duration.ofSeconds(60))
                .logRequests(true)
                .logResponses(true)
                .build();
    }

}
