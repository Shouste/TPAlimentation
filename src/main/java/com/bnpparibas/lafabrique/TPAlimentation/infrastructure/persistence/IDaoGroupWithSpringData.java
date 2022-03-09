package com.bnpparibas.lafabrique.TPAlimentation.infrastructure.persistence;

import com.bnpparibas.lafabrique.TPAlimentation.domain.FoodGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDaoGroupWithSpringData extends CrudRepository<FoodGroup, String> {


}
