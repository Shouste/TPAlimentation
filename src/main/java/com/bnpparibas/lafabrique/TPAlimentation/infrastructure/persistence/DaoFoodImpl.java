package com.bnpparibas.lafabrique.TPAlimentation.infrastructure.persistence;

import com.bnpparibas.lafabrique.TPAlimentation.domain.Food;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DaoFoodImpl implements IDaoFood {


    @Override
    public List<Food> getFoodByName(String name) {

        SessionFactory sessionFactory = DaoFactory.createSession();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String crit = "%"+name+"%";
        Query query = session.createQuery("select f from Food f where f.foodName like :name");
        query.setParameter("name", crit);

        List<Food> foodList = query.getResultList();
        session.close();

        return foodList;
    }

    @Override
    public Food getFoodById(String id) {

        SessionFactory sessionFactory = DaoFactory.createSession();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {

            Query query = session.createQuery(
                    "select f from Food f join fetch f.listComponents where f.id = :id");
            query.setParameter("id", id);
            Food food = (Food) query.getSingleResult();

            if (food == null){
                throw new NoResultException("Food not found");
            }
            return food;

        }

        finally {

            session.close();

        }

    }

}
