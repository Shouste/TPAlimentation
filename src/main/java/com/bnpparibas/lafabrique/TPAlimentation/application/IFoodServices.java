package com.bnpparibas.lafabrique.TPAlimentation.application;

import com.bnpparibas.lafabrique.TPAlimentation.domain.Food;
import com.bnpparibas.lafabrique.TPAlimentation.exposition.FoodDto;
import com.bnpparibas.lafabrique.TPAlimentation.exposition.FoodListDto;

import java.util.List;

public interface IFoodServices {

    List<FoodListDto> getFoodByName(String name);

    FoodDto getFoodById(String id);

    FoodDto convertFoodToFoodDto(Food food);

    FoodListDto convertFoodToFoodListDto(Food food);

    void fileLoad();
}
