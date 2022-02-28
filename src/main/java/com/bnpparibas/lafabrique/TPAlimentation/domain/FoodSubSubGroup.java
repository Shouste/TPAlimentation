package com.bnpparibas.lafabrique.TPAlimentation.domain;

import javax.persistence.*;

@Entity
public class FoodSubSubGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 6)
    private String publicId; //Id contenu dans le fichier d'origine

    @Column(length = 50)
    private String name;

    @ManyToOne
    private FoodSubGroup foodSubGroup;

    // Constructors

    public FoodSubSubGroup(){}

    public FoodSubSubGroup(String publicId, String name, FoodSubGroup foodSubGroup) {
        this.publicId = publicId;
        this.name = name;
        this.foodSubGroup = foodSubGroup;
    }

    // Getters & setters

    public Long getId() {
        return id;
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
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
