package com.bnpparibas.lafabrique.TPAlimentation.domain;

import javax.persistence.*;

@Entity
@Table(name="FoodSubSubGroup")
public class FoodSubSubGroup {

    @Id
    @Column(unique = true, length = 6)
    private String id; //Id contenu dans le fichier d'origine

    @Column(length = 50)
    private String name;

    @ManyToOne
    private FoodSubGroup foodSubGroup;

    // Constructors

    public FoodSubSubGroup(){}

    public FoodSubSubGroup(String id, String name, FoodSubGroup foodSubGroup) {
        this.id = id;
        this.name = name;
        this.foodSubGroup = foodSubGroup;
    }

    // Getters & setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FoodSubGroup getFoodSubGroup() {
        return foodSubGroup;
    }

    public void setFoodSubGroup(FoodSubGroup foodSubGroup) {
        this.foodSubGroup = foodSubGroup;
    }

}
