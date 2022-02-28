package com.bnpparibas.lafabrique.TPAlimentation.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ComponentType componentType; // Enum

    private Double quantity;


    // Constructor

    public Component(ComponentType componentType, Double quantity) {
        this.componentType = componentType;
        this.quantity = quantity;
    }

    // Getters & setters

    public Long getId() {
        return id;
    }

    public ComponentType getComponentType() {
        return componentType;
    }

    public void setComponentType(ComponentType componentType) {
        this.componentType = componentType;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

}
