package com.bnpparibas.lafabrique.TPAlimentation.domain;

import javax.persistence.*;

@Entity
@Table(name="FoodSubGroup")
public class FoodSubGroup {

    @Id
    @Column(unique = true, length = 4)
    private String id; //Id contenu dans le fichier d'origine

    @Column(length = 50)
    private String name;

    @ManyToOne
    private FoodGroup foodGroup;

    // Constructors
    public FoodSubGroup(){}

    public FoodSubGroup(String id, String name, FoodGroup foodGroup) {
        this.id = id;
        this.name = name;
        this.foodGroup = foodGroup;
    }

    // Getters & setters

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFoodGroup(FoodGroup foodGroup) {
        this.foodGroup = foodGroup;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public FoodGroup getFoodGroup() {
        return foodGroup;
    }
}
