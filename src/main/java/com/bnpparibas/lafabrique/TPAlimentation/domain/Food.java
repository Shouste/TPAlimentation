package com.bnpparibas.lafabrique.TPAlimentation.domain;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.List;

@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private FoodSubGroup foodSubGroup;

    private FoodSubSubGroup foodSubSubGroup;

    @NaturalId
    @Column(unique = true)
    private String food_code; // public id of food

    private String alim_nom_sci;

    @NaturalId
    @Column(length = 150)
    private String foodName;

    private double kJEnergy; // Energie, Règlement UE N° 1169/2011 (kJ/100 g)

    private double kCalEnergy; //Energie, Règlement UE N° 1169/2011 (kcal/100 g)

    private double kJwithFibersEnergy; // Energie, N x facteur Jones kJ

    private double kcalwithFibersEnergy; //Energie, N x facteur Jones kCal

    @OneToMany
    private List<Component> listComponents;

    //Constructors

    public Food(){}

    public Food(FoodSubGroup foodSubGroup, FoodSubSubGroup foodSubSubGroup, String food_code, String alim_nom_sci, String foodName, double kJEnergy, double kCalEnergy, double kJwithFibersEnergy, double kcalwithFibersEnergy, List<Component> listComponents) {
        this.foodSubGroup = foodSubGroup;
        this.foodSubSubGroup = foodSubSubGroup;
        this.food_code = food_code;
        this.alim_nom_sci = alim_nom_sci;
        this.foodName = foodName;
        this.kJEnergy = kJEnergy;
        this.kCalEnergy = kCalEnergy;
        this.kJwithFibersEnergy = kJwithFibersEnergy;
        this.kcalwithFibersEnergy = kcalwithFibersEnergy;
        this.listComponents = listComponents;
    }

    //Getters & Setters

    public Long getId() {
        return id;
    }

    public FoodSubGroup getFoodSubGroup() {
        return foodSubGroup;
    }

    public void setFoodSubGroup(FoodSubGroup foodSubGroup) {
        this.foodSubGroup = foodSubGroup;
    }

    public FoodSubSubGroup getFoodSubSubGroup() {
        return foodSubSubGroup;
    }

    public void setFoodSubSubGroup(FoodSubSubGroup foodSubSubGroup) {
        this.foodSubSubGroup = foodSubSubGroup;
    }

    public String getFood_code() {
        return food_code;
    }

    public void setFood_code(String food_code) {
        this.food_code = food_code;
    }

    public String getAlim_nom_sci() {
        return alim_nom_sci;
    }

    public void setAlim_nom_sci(String alim_nom_sci) {
        this.alim_nom_sci = alim_nom_sci;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getkJEnergy() {
        return kJEnergy;
    }

    public void setkJEnergy(double kJEnergy) {
        this.kJEnergy = kJEnergy;
    }

    public double getkCalEnergy() {
        return kCalEnergy;
    }

    public void setkCalEnergy(double kCalEnergy) {
        this.kCalEnergy = kCalEnergy;
    }

    public double getkJwithFibersEnergy() {
        return kJwithFibersEnergy;
    }

    public void setkJwithFibersEnergy(double kJwithFibersEnergy) {
        this.kJwithFibersEnergy = kJwithFibersEnergy;
    }

    public double getKcalwithFibersEnergy() {
        return kcalwithFibersEnergy;
    }

    public void setKcalwithFibersEnergy(double kcalwithFibersEnergy) {
        this.kcalwithFibersEnergy = kcalwithFibersEnergy;
    }

    public List<Component> getListComponents() {
        return listComponents;
    }

    public void setListComponents(List<Component> listComponents) {
        this.listComponents = listComponents;
    }
}
