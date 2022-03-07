package com.bnpparibas.lafabrique.TPAlimentation.application;

import com.bnpparibas.lafabrique.TPAlimentation.domain.Component;
import com.bnpparibas.lafabrique.TPAlimentation.domain.Food;
import com.bnpparibas.lafabrique.TPAlimentation.exposition.ComponentDto;
import com.bnpparibas.lafabrique.TPAlimentation.exposition.FoodDto;
import com.bnpparibas.lafabrique.TPAlimentation.exposition.FoodListDto;
import com.bnpparibas.lafabrique.TPAlimentation.infrastructure.external.IChuckNorrisJokes;
import com.bnpparibas.lafabrique.TPAlimentation.infrastructure.persistence.IDaoFood;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodServicesImpl implements IFoodServices {

    // TEST LOGGING
    private static final Logger logger
            = LoggerFactory.getLogger(FoodServicesImpl.class);

    @Autowired
    IDaoFood daoFood;

    @Autowired
    IChuckNorrisJokes chuckNorrisJokes;

    @Override
    public List<FoodListDto> getFoodByName(String name) {

        List<FoodListDto> foodListDtos = new ArrayList<>();

        List<Food> foodList =  daoFood.getFoodByName(name);

        for(Food f : foodList){
            foodListDtos.add(convertFoodToFoodListDto(f));
        }

        String joke = chuckNorrisJokes.getALittleJoke();
        logger.info("A little joke from Chuck Norris makes my day : {}", joke);

        return foodListDtos;
    }

    @Override
    public FoodDto getFoodById(String id) {
        Food food =  daoFood.getFoodById(id);
        return convertFoodToFoodDto(food);

    }

    public FoodDto convertFoodToFoodDto(Food food){

        if (food == null) {return null;}

        List<ComponentDto> componentDtoList = new ArrayList<>();
        for(Component comp:food.getListComponents()){
            componentDtoList.add(new ComponentDto(comp.getComponentType(), comp.getQuantity()));
        }

        String subSubGroupName = null;
        if (food.getFoodSubSubGroup() != null){
            subSubGroupName = food.getFoodSubSubGroup().getName();
        }

        return new FoodDto( food.getFoodSubGroup().getFoodGroup().getName(),
                            food.getFoodSubGroup().getName(),
                            subSubGroupName,
                            food.getFood_code(),
                            food.getAlimNomSci(),
                            food.getFoodName(),
                            food.getkJEnergy(),
                            food.getkCalEnergy(),
                            food.getkJwithFibersEnergy(),
                            food.getKcalwithFibersEnergy(),
                            componentDtoList
                            );

    }

    public FoodListDto convertFoodToFoodListDto(Food food){

        if (food == null) {return null;}

        String subSubGroupName;
        if (food.getFoodSubSubGroup() == null){subSubGroupName = "";}
        else {subSubGroupName = food.getFoodSubSubGroup().getName();}

        return new FoodListDto( food.getFood_code(),
                                food.getFoodName(),
                                food.getFoodSubGroup().getFoodGroup().getName(),
                                food.getFoodSubGroup().getName(),
                                subSubGroupName);

    }

}
