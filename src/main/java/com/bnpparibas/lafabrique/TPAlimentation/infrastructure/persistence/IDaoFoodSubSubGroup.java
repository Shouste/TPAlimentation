package com.bnpparibas.lafabrique.TPAlimentation.infrastructure.persistence;

import com.bnpparibas.lafabrique.TPAlimentation.domain.FoodSubSubGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IDaoFoodSubSubGroup extends CrudRepository<FoodSubSubGroup, String> {
}
