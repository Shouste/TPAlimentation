package com.bnpparibas.lafabrique.TPAlimentation.domain;

import javax.persistence.*;

public class FoodSubGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String publicId; //Id contenu dans le fichier d'origine

    @Column(length = 50)
    private String name;

    @ManyToOne
    private FoodGroup foodGroup;


    // Constructors
    public FoodSubGroup(){}

    public FoodSubGroup(String publicId, String name, FoodGroup foodGroup) {
        this.publicId = publicId;
        this.name = name;
        this.foodGroup = foodGroup;
    }

    // Getters & setters

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFoodGroup(FoodGroup foodGroup) {
        this.foodGroup = foodGroup;
    }

    public Long getId() {
        return id;
    }

    public String getPublicId() {
        return publicId;
    }

    public String getName() {
        return name;
    }

    public FoodGroup getFoodGroup() {
        return foodGroup;
    }
}
