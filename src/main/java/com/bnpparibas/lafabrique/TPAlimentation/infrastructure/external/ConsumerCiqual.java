package com.bnpparibas.lafabrique.TPAlimentation.infrastructure.external;

import com.bnpparibas.lafabrique.TPAlimentation.application.IFoodServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerCiqual {

    @Autowired
    IFoodServices foodServices;

    @JmsListener( destination = "my_Queue_Ciqual")
    public void consume(String message) {

        System.out.println(message);
        foodServices.fileLoad();
        System.out.println("chargement terminé");

    }

}
