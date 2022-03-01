package com.bnpparibas.lafabrique.TPAlimentation.exposition;

import java.util.List;

public class FoodDto {

    private final String foodGroupName;

    private final String foodSubGroupName;

    private final String foodSubSubGroupName;

    private final String foodCode; // public id of food

    private final String alimNomSci;

    private final String foodName;

    private final String kJEnergy; // Energie, Règlement UE N° 1169/2011 (kJ/100 g)

    private final String kCalEnergy; //Energie, Règlement UE N° 1169/2011 (kcal/100 g)

    private final String kJwithFibersEnergy; // Energie, N x facteur Jones kJ

    private final String kcalwithFibersEnergy; //Energie, N x facteur Jones kCal

    private final List<ComponentDto> listComponentsDto;

    //Constructor

    public FoodDto(String foodGroupName, String foodSubGroupName, String foodSubSubGroupName, String food_code, String alimNomSci, String foodName, String kJEnergy, String kCalEnergy, String kJwithFibersEnergy, String kcalwithFibersEnergy, List<ComponentDto> listComponentsDto) {
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

    public String getkJEnergy() {
        return kJEnergy;
    }

    public String getkCalEnergy() {
        return kCalEnergy;
    }

    public String getkJwithFibersEnergy() {
        return kJwithFibersEnergy;
    }

    public String getKcalwithFibersEnergy() {
        return kcalwithFibersEnergy;
    }

    public List<ComponentDto> getListComponentsDto() {
        return listComponentsDto;
    }
}
