package com.bnpparibas.lafabrique.TPAlimentation.exposition;

import com.bnpparibas.lafabrique.TPAlimentation.domain.FoodSubGroup;
import com.bnpparibas.lafabrique.TPAlimentation.domain.FoodSubSubGroup;

public class FoodListDto {

    private final String food_code; // public id of food

    private final String foodName;

    private final FoodSubGroup foodSubGroup;

    private final FoodSubSubGroup foodSubSubGroup;

    //Constructor

    public FoodListDto(String food_code, String foodName, FoodSubGroup foodSubGroup, FoodSubSubGroup foodSubSubGroup) {
        this.food_code = food_code;
        this.foodName = foodName;
        this.foodSubGroup = foodSubGroup;
        this.foodSubSubGroup = foodSubSubGroup;
    }

    //Getters

    public String getFood_code() {
        return food_code;
    }

    public String getFoodName() {
        return foodName;
    }

    public FoodSubGroup getFoodSubGroup() {
        return foodSubGroup;
    }

    public FoodSubSubGroup getFoodSubSubGroup() {
        return foodSubSubGroup;
    }

}
