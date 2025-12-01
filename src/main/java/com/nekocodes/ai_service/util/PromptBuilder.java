package com.nekocodes.ai_service.util;

import org.springframework.stereotype.Component;

import com.nekocodes.ai_service.DTO.FormData;

@Component
public class PromptBuilder {

  public String buildMealSuggestionPrompt(FormData formData) {
    return String.format("""
        You are a smart meal suggestion AI system.

        Based strictly on the user's preferences and constraints, suggest 6 meal ideas that are:
        - Healthy
        - Easy to prepare
        - Suitable for their activity level and dietary profile
        - Matching their cuisine and meal type preferences

        User Preferences:
        Family Size: %s
        Cooking Time: %s
        Budget: %s
        Allergies: %s
        Dietary Restrictions: %s
        Meal Types: %s
        Preferred Cuisines: %s
        Cooking Skill Level: %s
        Meal Frequency: %s
        Age: %d
        Height: %d cm
        Weight: %d kg
        Activity Level: %s
        Liked Food: %s
        Disliked Food: %s
        Goal: %s
        Gender: %s

        Follow these rules STRICTLY:
        - Use ONLY the above data.
        - Avoid disliked foods completely.
        - Prefer liked foods where possible.
        - Ensure meals suit the user's activity level and meal type.
        - Return ONLY valid JSON. No explanation. No markdown.

        Response format:
        {
          "suggestions": [
            {
              "id": 1,
              "name": "...",
              "type": "...",
              "cookTime": "...",
              "servings": "...",
              "ingredients": [],
              "difficulty": "Easy"
            }
          ]
        }
        """,
        formData.getFamilySize(),
        formData.getCookingTime(),
        formData.getBudget(),
        String.join(", ", formData.getAllergies()),
        String.join(", ", formData.getDietaryRestrictions()),
        String.join(", ", formData.getMealTypes()),
        String.join(", ", formData.getPreferredCuisines()),
        formData.getCookingSkillLevel(),
        formData.getMealFrequency(),
        formData.getAge(),
        formData.getHeight(),
        formData.getWeight(),
        formData.getActivityLevel(),
        formData.getLikedFood(),
        formData.getDislikedFood(),
        formData.getGoal(),
        formData.getGender());
  }
}
