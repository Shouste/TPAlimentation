package com.bnpparibas.lafabrique.TPAlimentation.infrastructure;

import com.bnpparibas.lafabrique.TPAlimentation.domain.Food;

import java.util.List;

public interface IDaoFood {

    List<Food> getFoodByName(String name);

    Food getFoodById(String id);

}
