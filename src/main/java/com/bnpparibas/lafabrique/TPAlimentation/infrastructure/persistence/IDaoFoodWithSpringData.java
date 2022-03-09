package com.bnpparibas.lafabrique.TPAlimentation.infrastructure.persistence;

import com.bnpparibas.lafabrique.TPAlimentation.domain.Food;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDaoFoodWithSpringData extends CrudRepository<Food, String> {

    @Query("select f from Food f where f.foodName like %:name%")
    List<Food> getFoodByName(String name);

    @Query("select f from Food f join fetch f.listComponents where f.id = :id")
    Food findFoodByFood_code(String id);

}
