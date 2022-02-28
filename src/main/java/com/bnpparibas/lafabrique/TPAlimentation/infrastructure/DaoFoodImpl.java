package com.bnpparibas.lafabrique.TPAlimentation.infrastructure;

import com.bnpparibas.lafabrique.TPAlimentation.domain.Food;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoFoodImpl implements IDaoFood {


    @Override
    public List<Food> getFoodByName(String name) {

        SessionFactory sessionFactory = DaoFactory.createSession();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //TO DO
        session.close();

        return null;
    }

    @Override
    public Food getFoodById(String id) {

        SessionFactory sessionFactory = DaoFactory.createSession();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //TO DO
        session.close();

        return null;
    }

}
