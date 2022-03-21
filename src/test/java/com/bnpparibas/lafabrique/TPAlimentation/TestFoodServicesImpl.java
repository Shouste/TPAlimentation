package com.bnpparibas.lafabrique.TPAlimentation;

import com.bnpparibas.lafabrique.TPAlimentation.application.FoodServicesImpl;
import com.bnpparibas.lafabrique.TPAlimentation.application.IFoodServices;
import com.bnpparibas.lafabrique.TPAlimentation.domain.*;
import com.bnpparibas.lafabrique.TPAlimentation.infrastructure.persistence.IDaoFoodWithSpringData;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TestFoodServicesImpl {

    final static FoodGroup fg1 = new FoodGroup("01","groupe 1");
    final static FoodSubGroup fsg1 = new FoodSubGroup("0101","sous-groupe1",fg1);
    final static Component c1 = new Component(ComponentType.FIBRES,"45.0");
    final static Component c2 = new Component(ComponentType.GLUCOSE,"22.0");
    final static List<Component> cList = new ArrayList(Arrays.asList(c1,c2));
    final static Food food1 = new Food(fsg1,null,"25601","","super plat",
            "12.587","23.5","54.8","41.9",cList);

    //@MockBean OU :
    @Mock
    private IDaoFoodWithSpringData daoFoodWithSpringData;

    //@Autowired
    //private IFoodServices foodServices;
    // OU :
    @InjectMocks
    FoodServicesImpl foodServices;

    @Test
    public void shouldReturn_1_Result_WhenIdOK(){
        when(daoFoodWithSpringData.findFoodByFood_code("10")).thenReturn(food1);
        assertThat(foodServices.getFoodById("10").getFoodCode().equals("25601")).isTrue();
    }


    @Test
    public void shouldReturn_ValidFoodDto_WhenFoodOK(){
        assertThat(foodServices.convertFoodToFoodDto(food1).getFoodCode().equals("25601")).isTrue();
        assertThat(foodServices.convertFoodToFoodDto(food1).getFoodName().equals("super plat")).isTrue();
        assertThat(foodServices.convertFoodToFoodDto(food1).getListComponentsDto().size() == 2).isTrue();
    }

    @Test
    public void shouldReturn_Null_WhenFoodNull() {
        assertThat(foodServices.convertFoodToFoodDto(null)).isNull();
    }

    // Tests conversion Food -> FoodDto for get list of foods
    @Test
    public void shouldReturn_Null_WhenFoodNull_Bis(){
        assertThat(foodServices.convertFoodToFoodListDto(null)).isNull();
    }

    @Test
    public void shouldReturn_ValidFoodListDto_WhenFoodOK(){
        assertThat(foodServices.convertFoodToFoodListDto(food1).getFoodName().equals("super plat")).isTrue();
        assertThat(foodServices.convertFoodToFoodListDto(food1).getFoodSubGroupName().equals("sous-groupe1")).isTrue();
        assertThat(foodServices.convertFoodToFoodListDto(food1).getFoodGroupName().equals("groupe 1")).isTrue();
    }

    @Test
    public void shouldReturn_ValidCount_WhenFoodIdOK(){
        when(daoFoodWithSpringData.findFoodByFood_code("25601")).thenReturn(food1);
        assertThat(foodServices.countComponentsForFood("25601")).isEqualTo(2);
    }

}
