package com.bnpparibas.lafabrique.TPAlimentation.domain;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Food")
public class Food {


    @Id
    @Column(name = "food_code")
    private String food_code; // public id of food

    @ManyToOne
    private FoodSubGroup foodSubGroup;

    @ManyToOne
    private FoodSubSubGroup foodSubSubGroup;

    @Column(name = "alimNomSci")
    private String alimNomSci;

    @NaturalId
    @Column(length = 150, name = "foodName")
    private String foodName;

    @Column(name = "kJEnergy")
    private String kJEnergy; // Energie, Règlement UE N° 1169/2011 (kJ/100 g)

    @Column(name = "kCalEnergy")
    private String kCalEnergy; //Energie, Règlement UE N° 1169/2011 (kcal/100 g)

    @Column(name = "kJwithFibersEnergy")
    private String kJwithFibersEnergy; // Energie, N x facteur Jones kJ

    @Column(name = "kcalwithFibersEnergy")
    private String kcalwithFibersEnergy; //Energie, N x facteur Jones kCal

    @Column(name = "listComponents")
    @OneToMany(fetch = FetchType.LAZY )
    private List<Component> listComponents;

    //Constructors

    public Food(){}

    public Food(FoodSubGroup foodSubGroup, FoodSubSubGroup foodSubSubGroup, String food_code, String alim_nom_sci, String foodName, String kJEnergy, String kCalEnergy, String kJwithFibersEnergy, String kcalwithFibersEnergy, List<Component> listComponents) {
        this.foodSubGroup = foodSubGroup;
        this.foodSubSubGroup = foodSubSubGroup;
        this.food_code = food_code;
        this.alimNomSci = alim_nom_sci;
        this.foodName = foodName;
        this.kJEnergy = kJEnergy;
        this.kCalEnergy = kCalEnergy;
        this.kJwithFibersEnergy = kJwithFibersEnergy;
        this.kcalwithFibersEnergy = kcalwithFibersEnergy;
        this.listComponents = listComponents;
    }

    //Getters & Setters

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

    public String getAlimNomSci() {
        return alimNomSci;
    }

    public void setAlimNomSci(String alimNomSci) {
        this.alimNomSci = alimNomSci;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getkJEnergy() {
        return kJEnergy;
    }

    public void setkJEnergy(String kJEnergy) {
        this.kJEnergy = kJEnergy;
    }

    public String getkCalEnergy() {
        return kCalEnergy;
    }

    public void setkCalEnergy(String kCalEnergy) {
        this.kCalEnergy = kCalEnergy;
    }

    public String getkJwithFibersEnergy() {
        return kJwithFibersEnergy;
    }

    public void setkJwithFibersEnergy(String kJwithFibersEnergy) {
        this.kJwithFibersEnergy = kJwithFibersEnergy;
    }

    public String getKcalwithFibersEnergy() {
        return kcalwithFibersEnergy;
    }

    public void setKcalwithFibersEnergy(String kcalwithFibersEnergy) {
        this.kcalwithFibersEnergy = kcalwithFibersEnergy;
    }

    public List<Component> getListComponents() {
        return listComponents;
    }

    public void setListComponents(List<Component> listComponents) {
        this.listComponents = listComponents;
    }
}
