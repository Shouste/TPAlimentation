package com.bnpparibas.lafabrique.TPAlimentation.exposition;

import com.bnpparibas.lafabrique.TPAlimentation.domain.ComponentType;

public class ComponentDto {

    private final ComponentType componentType; // Enum

    private final String quantity;

    public ComponentDto(ComponentType componentType, String quantity) {
        this.componentType = componentType;
        this.quantity = quantity;
    }

    public ComponentType getComponentType() {
        return componentType;
    }

    public String getQuantity() {
        return quantity;
    }

}
