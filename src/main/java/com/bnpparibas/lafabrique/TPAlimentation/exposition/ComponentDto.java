package com.bnpparibas.lafabrique.TPAlimentation.exposition;

import com.bnpparibas.lafabrique.TPAlimentation.domain.ComponentType;

public class ComponentDto {

    private final ComponentType componentType; // Enum

    private final Double quantity;

    public ComponentDto(ComponentType componentType, Double quantity) {
        this.componentType = componentType;
        this.quantity = quantity;
    }

    public ComponentType getComponentType() {
        return componentType;
    }

    public Double getQuantity() {
        return quantity;
    }

}
