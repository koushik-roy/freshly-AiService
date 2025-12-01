package com.nekocodes.ai_service.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class FormData {
    private String familySize;
    private String cookingTime;
    private String budget;
    private List<String> allergies;
    private List<String> dietaryRestrictions;
    private List<String> mealPreferences;
    private String cookingSkillLevel;
    private List<String> mealTypes;
    private List<String> preferredCuisines;
    private String mealFrequency;
    private int age;
    private int height;
    private int weight;
    private String activityLevel;
    private String likedFood;
    private String dislikedFood;
    private String goal;
    private String gender;

    public String toString() {
        return "familySize=" + familySize +
                ", cookingTime=" + cookingTime +
                ", allergies=" + allergies +
                ", dietaryRestrictions=" + dietaryRestrictions +
                ", mealTypes=" + mealTypes +
                ", preferredCuisines=" + preferredCuisines +
                ", activityLevel=" + activityLevel +
                ", likedFood=" + likedFood +
                ", dislikedFood=" + dislikedFood;
    }
}
