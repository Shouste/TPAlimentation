package com.bnpparibas.lafabrique.TPAlimentation.exposition;

import com.bnpparibas.lafabrique.TPAlimentation.application.IFoodServices;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/food")
public class FoodExpositionServices {

    @Autowired
    IFoodServices foodServices;

    @ApiOperation(value = "Get a list of food by name", notes ="Response = list of all foods containing the provided name. " +
            "The search is case-sensitive\n Example : /food/name=Pastis")
    @GetMapping("/name={name}")
    // @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    public List<FoodListDto> getFoodByName(
            @ApiParam(value = "Name of searched food. Case-sensitive", required = true)
            @PathVariable("name") String name){

        try {

            return foodServices.getFoodByName(name);
        }

        catch (NoResultException e){
            throw new ResponseStatusException(NOT_FOUND, e.getMessage(), e);
        }

    }

    @ApiOperation(value = "Get a food by its id", notes = "Example : /food/id=1000")
    @GetMapping("/id={id}")
    public FoodDto getFoodById(
            @ApiParam(value = "Id of searched food", required = true)
            @PathVariable("id") String id) {

        try {

            return foodServices.getFoodById(id);

        }

        catch (NoResultException e){
            throw new ResponseStatusException(NOT_FOUND, e.getMessage(), e);
        }

    }

}
