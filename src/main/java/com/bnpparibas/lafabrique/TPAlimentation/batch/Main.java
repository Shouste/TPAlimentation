package com.bnpparibas.lafabrique.TPAlimentation.batch;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    /*
    Batch de chargement de la base de données, à partir d'un fichier Excel
     */

    public static void main(String[] args) {

        File doc =
                new File("C:\\Users\\Sandrine\\projects\\Ressources\\Table_Ciqual_2020_FR_2020_07_07.csv");

        try {

            BufferedReader br = new BufferedReader(new FileReader(doc));


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
        List<String> recordAsArray = Arrays.asList(record.split(";"));
        return recordAsArray;
    }

    public static void insertFoodIntoDb(List<String> stringArray){
        // TO DO

    }

}
