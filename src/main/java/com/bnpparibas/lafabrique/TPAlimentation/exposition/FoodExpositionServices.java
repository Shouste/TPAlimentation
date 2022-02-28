package com.bnpparibas.lafabrique.TPAlimentation.exposition;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodExpositionServices {


    @GetMapping("/{name}")
    public List<FoodListDto> getFoodByName(@PathVariable("name") String name){

        return null;
    }

    @GetMapping("/{id}")
    public FoodDto getFoodById(@PathVariable("id") String id){

        return null;

    }


}
