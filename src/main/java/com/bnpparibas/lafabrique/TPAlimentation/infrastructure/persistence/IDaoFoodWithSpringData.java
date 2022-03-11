package com.bnpparibas.lafabrique.TPAlimentation.infrastructure.persistence;

import com.bnpparibas.lafabrique.TPAlimentation.domain.Food;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDaoFoodWithSpringData extends CrudRepository<Food, String> {

    List<Food> findFirst10ByFoodNameContaining(String name);

    @Query("select f from Food f join fetch f.listComponents where f.id = :id")
    Food findFoodByFood_code(String id);

}
