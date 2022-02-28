package com.bnpparibas.lafabrique.TPAlimentation.exposition;

public class FoodListDto {

    private final String food_code; // public id of food

    private final String foodName;

    private final String foodGroupName;

    private final String foodSubGroupName;

    private final String foodSubSubGroupName;

    //Constructor

    public FoodListDto(String food_code, String foodName, String foodGroupName, String foodSubGroupName, String foodSubSubGroupName) {
        this.food_code = food_code;
        this.foodName = foodName;
        this.foodGroupName = foodGroupName;
        this.foodSubGroupName = foodSubGroupName;
        this.foodSubSubGroupName = foodSubSubGroupName;
    }

    //Getters

    public String getFood_code() {
        return food_code;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodGroupName() {
        return foodGroupName;
    }

    public String getFoodSubGroupName() {
        return foodSubGroupName;
    }

    public String getFoodSubSubGroupName() {
        return foodSubSubGroupName;
    }

}
