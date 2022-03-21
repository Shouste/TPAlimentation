package com.bnpparibas.lafabrique.TPAlimentation.application;

import com.bnpparibas.lafabrique.TPAlimentation.domain.*;
import com.bnpparibas.lafabrique.TPAlimentation.exposition.ComponentDto;
import com.bnpparibas.lafabrique.TPAlimentation.exposition.FoodDto;
import com.bnpparibas.lafabrique.TPAlimentation.exposition.FoodListDto;
import com.bnpparibas.lafabrique.TPAlimentation.infrastructure.external.IChuckNorrisJokes;
import com.bnpparibas.lafabrique.TPAlimentation.infrastructure.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class FoodServicesImpl implements IFoodServices {

    // TEST LOGGING
    private static final Logger logger
            = LoggerFactory.getLogger(FoodServicesImpl.class);

    @Autowired
    //IDaoFood daoFood;
    IDaoFoodWithSpringData daoFood;

    @Autowired
    IDaoComponentWithSpringData daoComponent;

    @Autowired
    IDaoGroupWithSpringData daoGroup;

    @Autowired
    IDaoFoodSubGroupWithSpringData daoSubGroup;

    @Autowired
    IDaoFoodSubSubGroup daoSubSubGroup;

    @Autowired
    IChuckNorrisJokes chuckNorrisJokes;

    @Override
    @CacheEvict(value = "food", allEntries=true) // Supprime toutes les entrées du cache (pour l'exemple)
    public List<FoodListDto> getFoodByName(String name) {

        if (!foodNameIsValid(name)){
            throw new IllegalArgumentException("Food name should be a string with letters, space, - '");
        }

        List<FoodListDto> foodListDtos = new ArrayList<>();

        List<Food> foodList =  daoFood.findFirst10ByFoodNameContaining(name.toLowerCase());

        for(Food f : foodList){
            foodListDtos.add(convertFoodToFoodListDto(f));
        }

        String joke = chuckNorrisJokes.getALittleJoke();
        logger.info("A little joke from Chuck Norris makes my day : {}", joke);

        return foodListDtos;
    }

    @Override
    @Cacheable(value = "food")
    public FoodDto getFoodById(String id) {
        if (!foodIdIsValid(id)){
            throw new IllegalArgumentException("Food id should contain only digits");
        }
        Food food =  daoFood.findFoodByFood_code(id);
        return convertFoodToFoodDto(food);
    }

    /**
     * Controls food id is valid
     * @param id = food id
     * @return true/false
     */
    private boolean foodIdIsValid(String id){
        // Food id should be an integer

        if (id.length() == 0){
            return false;
        }
        try {Integer.parseInt(id);}
        catch (NumberFormatException e){
            return false;
        }

        return true;
    }


    private boolean foodNameIsValid(String name){
        // Food name should contain letters

        if (name.length() == 0){
            return false;
        }

        // toutes lettres minuscules et majuscules, y compris les caractères accentués, ainsi que le blanc et le tiret
        return name.matches("[a-zA-Z-'\\sÀÁÂÃÄÅÇÑñÈÉÊËÌÍÎÏÒÓÔÕÖØÙÚÛÜÝàáâãäåçèéêëìíîïðòóôõöøùúûüýÿ]+");

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


    public void fileLoad() {

        System.out.println("daoGroup :" + daoGroup);
        System.out.println("daoFood :" + daoFood);
        System.out.println("daoSubGroup :" + daoSubGroup);
        System.out.println("daoSubSubGroup :" + daoSubSubGroup);

        File doc =
                new File("C:\\Users\\Sandrine\\projects\\Ressources\\Table_Ciqual_2020_FR_2020_07_07-2.csv");

        try {

            FileInputStream fis = new FileInputStream(doc);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);

            while (true) {
                try {
                    String record = br.readLine();
                    if (record == null) {
                        System.out.println("fin du fichier");
                        break;
                    } else {
                        List<String> stringArray = parseRecord(record);
                        if (!stringArray.get(0).startsWith("a")){
                            insertFoodIntoDb(stringArray);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

    }

    @Override
    public int countComponentsForFood(String id) {
        Food food = daoFood.findFoodByFood_code(id);
        return food.getListComponents().size();
    }

    // Il existe aussi des bibliothèques qui permettent de manipuler les csv plus facilement (utiliser les entêtes de
    // colonne pour faire référence aux colonnes, etc
    // ex : Apache Commons CSV (attention aux vulnérabilités)

    public List<String> parseRecord(String record){

        return Arrays.asList(record.toLowerCase().split(";"));
    }

    public void insertFoodIntoDb(List<String> stringArray){

        // Search of subGoup & subSubGroup corresponding to this record

        FoodGroup foodGroup = findOrCreateFoodGroup(stringArray.get(0), stringArray.get(3));

        FoodSubGroup foodSubGroup = findOrCreateFoodSubGroup(stringArray.get(1), stringArray.get(4), foodGroup);

        FoodSubSubGroup foodSubSubGroup = null;
        if (!stringArray.get(2).equals("000000")){   // if code = "000000", no sub-sub-group for this food
            foodSubSubGroup = findOrCreateFoodSubSubGroup(stringArray.get(2), stringArray.get(5), foodSubGroup);
        }

        // Objet Food instantiation

        Food food = new Food();

        food.setFoodSubGroup(foodSubGroup);
        food.setFoodSubSubGroup(foodSubSubGroup);
        food.setFood_code(stringArray.get(6));
        food.setFoodName(stringArray.get(7));
        if (stringArray.size() >= 9) food.setAlimNomSci(stringArray.get(8));
        if (stringArray.size() >= 10) food.setkJEnergy(stringArray.get(9));
        if (stringArray.size() >= 11) food.setkCalEnergy(stringArray.get(10));
        if (stringArray.size() >= 12) food.setkJwithFibersEnergy(stringArray.get(11));
        if (stringArray.size() >= 13) food.setKcalwithFibersEnergy(stringArray.get(12));

        // Creation of components in db and add in the component list for this food
        List<Component> componentList = new ArrayList<>();
        for (int i = 13; i < stringArray.size() ; i++) {

            if (!stringArray.get(i).equals("-")&& !stringArray.get(i).equals("")){ //  "-" means that this food doesn't contain this component
                // A bit tricky : the indexes of the enum ComponentType, beginning at zero, match the indexes of the array, beginning at the 13th element
                Component component = new Component(ComponentType.values()[i-13], stringArray.get(i));
                // Component creation in db
                daoComponent.save(component);
                // Add in the component list
                componentList.add(component);
            }

        }

        food.setListComponents(componentList);

        daoFood.save(food);

    }

    public FoodGroup findOrCreateFoodGroup(String groupId, String groupName) {

        FoodGroup foodGroup2;

        System.out.println("recherche du groupe "+groupId);
        Optional<FoodGroup> foodGroup = daoGroup.findById(groupId);


        if (!foodGroup.isPresent()) {
            System.out.println("Groupe non trouvé :" + groupId);
            foodGroup2 = new FoodGroup(groupId, groupName);

            daoGroup.save(foodGroup2);
            System.out.println("Groupe créé :" + groupId);
        } else {
            foodGroup2 = foodGroup.get();
        }

        return foodGroup2;

    }

    public FoodSubGroup findOrCreateFoodSubGroup(String subGroupId, String subGroupName, FoodGroup foodGroup) {

        Optional<FoodSubGroup> foodSubGroup = daoSubGroup.findById(subGroupId);
        FoodSubGroup foodSubGroup2;

        if (!foodSubGroup.isPresent()){
            System.out.println("Sous-groupe non trouvé :" + subGroupId);
            foodSubGroup2 = new FoodSubGroup(subGroupId, subGroupName, foodGroup);

            daoSubGroup.save(foodSubGroup2);
            System.out.println("Sous-groupe créé :" + subGroupId);
        } else {
            foodSubGroup2 = foodSubGroup.get();
        }

        return foodSubGroup2;

    }

    public FoodSubSubGroup findOrCreateFoodSubSubGroup(String subSubGroupId, String subSubGroupName, FoodSubGroup foodSubGroup) {

        Optional<FoodSubSubGroup> foodSubSubGroup = daoSubSubGroup.findById(subSubGroupId);
        FoodSubSubGroup foodSubSubGroup2;

        if (!foodSubSubGroup.isPresent()){
            System.out.println("Sous-sous-groupe non trouvé :" + subSubGroupId);
            foodSubSubGroup2 = new FoodSubSubGroup(subSubGroupId, subSubGroupName, foodSubGroup);

            daoSubSubGroup.save(foodSubSubGroup2);
            System.out.println("Sous-sous-groupe créé :" + subSubGroupId);
        } else {
            foodSubSubGroup2 = foodSubSubGroup.get();
        }

        return foodSubSubGroup2;

    }

}
