package com.bnpparibas.lafabrique.TPAlimentation.domain;

import javax.persistence.*;

@Entity
public class FoodGroup {

    @Id
    @Column(unique = true, length = 2)
    private String id; //Id contenu dans le fichier d'origine

    @Column(length = 50)
    private String name;

    // Constructors

    public FoodGroup() {}

    public FoodGroup(String id, String name) {
        this.id = id;
        this.name = name;
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

}
