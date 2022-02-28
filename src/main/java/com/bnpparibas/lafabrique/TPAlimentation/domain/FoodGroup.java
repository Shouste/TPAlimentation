package com.bnpparibas.lafabrique.TPAlimentation.domain;

import javax.persistence.*;

@Entity
public class FoodGroup {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String publicId; //Id contenu dans le fichier d'origine

    @Column(length = 50)
    private String name;

    // Constructors

    public FoodGroup() {}

    public FoodGroup(String publicId, String name) {
        this.publicId = publicId;
        this.name = name;
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

}
