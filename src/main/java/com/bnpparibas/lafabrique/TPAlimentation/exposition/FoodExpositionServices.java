package com.bnpparibas.lafabrique.TPAlimentation.exposition;

import com.bnpparibas.lafabrique.TPAlimentation.application.IFoodServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.NoResultException;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/food")
public class FoodExpositionServices {

    @Autowired
    IFoodServices foodServices;

    @GetMapping("/name={name}")
    public List<FoodListDto> getFoodByName(@PathVariable("name") String name){

        try {

            return foodServices.getFoodByName(name);
        }

        catch (NoResultException e){
            throw new ResponseStatusException(NOT_FOUND, e.getMessage(), e);
        }

    }

    @GetMapping("/id={id}")
    public FoodDto getFoodById(@PathVariable("id") String id) {

        try {

            return foodServices.getFoodById(id);

        }

        catch (NoResultException e){
            throw new ResponseStatusException(NOT_FOUND, e.getMessage(), e);
        }

    }

}
