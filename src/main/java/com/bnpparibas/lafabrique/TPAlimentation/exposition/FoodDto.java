package com.bnpparibas.lafabrique.TPAlimentation.exposition;

import java.util.List;

public class FoodDto {

    private final String foodGroupName;

    private final String foodSubGroupName;

    private final String foodSubSubGroupName;

    private final String foodCode; // public id of food

    private final String alimNomSci;

    private final String foodName;

    private final double kJEnergy; // Energie, Règlement UE N° 1169/2011 (kJ/100 g)

    private final double kCalEnergy; //Energie, Règlement UE N° 1169/2011 (kcal/100 g)

    private final double kJwithFibersEnergy; // Energie, N x facteur Jones kJ

    private final double kcalwithFibersEnergy; //Energie, N x facteur Jones kCal

    private final List<ComponentDto> listComponentsDto;

    //Constructor

    public FoodDto(String foodGroupName, String foodSubGroupName, String foodSubSubGroupName, String food_code, String alimNomSci, String foodName, double kJEnergy, double kCalEnergy, double kJwithFibersEnergy, double kcalwithFibersEnergy, List<ComponentDto> listComponentsDto) {
        this.foodGroupName = foodGroupName;
        this.foodSubGroupName = foodSubGroupName;
        this.foodSubSubGroupName = foodSubSubGroupName;
        this.foodCode = food_code;
        this.alimNomSci = alimNomSci;
        this.foodName = foodName;
        this.kJEnergy = kJEnergy;
        this.kCalEnergy = kCalEnergy;
        this.kJwithFibersEnergy = kJwithFibersEnergy;
        this.kcalwithFibersEnergy = kcalwithFibersEnergy;
        this.listComponentsDto = listComponentsDto;
    }

    //Getters & setters

    public String getFoodGroupName() {
        return foodGroupName;
    }

    public String getFoodSubGroupName() {
        return foodSubGroupName;
    }

    public String getFoodSubSubGroupName() {
        return foodSubSubGroupName;
    }

    public String getFoodCode() {
        return foodCode;
    }

    public String getAlimNomSci() {
        return alimNomSci;
    }

    public String getFoodName() {
        return foodName;
    }

    public double getkJEnergy() {
        return kJEnergy;
    }

    public double getkCalEnergy() {
        return kCalEnergy;
    }

    public double getkJwithFibersEnergy() {
        return kJwithFibersEnergy;
    }

    public double getKcalwithFibersEnergy() {
        return kcalwithFibersEnergy;
    }

    public List<ComponentDto> getListComponentsDto() {
        return listComponentsDto;
    }
}
