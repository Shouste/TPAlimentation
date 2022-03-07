package com.bnpparibas.lafabrique.TPAlimentation.batch;

import com.bnpparibas.lafabrique.TPAlimentation.domain.*;
import com.bnpparibas.lafabrique.TPAlimentation.infrastructure.persistence.DaoFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    /*
    Batch de chargement de la base de données, à partir d'un fichier Excel
     */

    static SessionFactory sessionFactory = DaoFactory.createSession();

    public static void main(String[] args) {

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

    public static List<String> parseRecord(String record){
        return Arrays.asList(record.split(";"));
    }

    public static void insertFoodIntoDb(List<String> stringArray){

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Search of subGoup & subSubGroup corresponding to this record

        FoodGroup foodGroup = findOrCreateFoodGroup(session, stringArray.get(0), stringArray.get(3));

        FoodSubGroup foodSubGroup = findOrCreateFoodSubGroup(session, stringArray.get(1), stringArray.get(4), foodGroup);

        FoodSubSubGroup foodSubSubGroup = null;
        if (!stringArray.get(2).equals("000000")){   // if code = "000000", no sub-sub-group for this food
            foodSubSubGroup = findOrCreateFoodSubSubGroup(session, stringArray.get(2), stringArray.get(5), foodSubGroup);
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
                session.save(component);
                // Add in the component list
                componentList.add(component);
            }

        }

        food.setListComponents(componentList);

        session.saveOrUpdate(food);

        session.getTransaction().commit();

    }

    public static FoodGroup findOrCreateFoodGroup(Session session, String groupId, String groupName) {

        FoodGroup foodGroup = session.get(FoodGroup.class, groupId);
        System.out.println("recherche du groupe "+groupId+ " : "+foodGroup);

        if (foodGroup == null) {
            System.out.println("Groupe non trouvé :" + groupId);
            foodGroup = new FoodGroup(groupId, groupName);

            session.save(foodGroup);
            System.out.println("Groupe créé :" + groupId);
        }
        return foodGroup;

    }

    public static FoodSubGroup findOrCreateFoodSubGroup(Session session, String subGroupId, String subGroupName, FoodGroup foodGroup) {

        FoodSubGroup foodSubGroup = session.get(FoodSubGroup.class, subGroupId);

        if (foodSubGroup == null){
            System.out.println("Sous-groupe non trouvé :" + subGroupId);
            foodSubGroup = new FoodSubGroup(subGroupId, subGroupName, foodGroup);

            session.save(foodSubGroup);
            System.out.println("Sous-groupe créé :" + subGroupId);
        }

        return foodSubGroup;

    }

    public static FoodSubSubGroup findOrCreateFoodSubSubGroup(Session session,String subSubGroupId, String subSubGroupName, FoodSubGroup foodSubGroup) {

        FoodSubSubGroup foodSubSubGroup = session.get(FoodSubSubGroup.class, subSubGroupId);

        if (foodSubSubGroup == null){
            System.out.println("Sous-sous-groupe non trouvé :" + subSubGroupId);
            foodSubSubGroup = new FoodSubSubGroup(subSubGroupId, subSubGroupName, foodSubGroup);

            session.save(foodSubSubGroup);
            System.out.println("Sous-sous-groupe créé :" + subSubGroupId);
        }

        return foodSubSubGroup;

    }

}
