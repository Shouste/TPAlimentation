package com.bnpparibas.lafabrique.TPAlimentation.exposition;

import com.bnpparibas.lafabrique.TPAlimentation.application.IFoodServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodExpositionServices {

    @Autowired
    IFoodServices foodServices;

    @GetMapping("/name={name}")
    public List<FoodListDto> getFoodByName(@PathVariable("name") String name){

        return foodServices.getFoodByName(name);
    }

    @GetMapping("/id={id}")
    public FoodDto getFoodById(@PathVariable("id") String id){

        return foodServices.getFoodById(id);

    }

}
