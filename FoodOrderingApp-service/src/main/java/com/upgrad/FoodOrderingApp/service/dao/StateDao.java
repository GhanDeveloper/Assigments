package com.upgrad.FoodOrderingApp.service.dao;


import com.upgrad.FoodOrderingApp.service.entity.AddressEntity;
import com.upgrad.FoodOrderingApp.service.entity.StateEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.UUID;

@Repository
public class StateDao {

    @PersistenceContext
    private EntityManager entityManager;


    public StateEntity getStateById(long id){
        try {
            return entityManager.createNamedQuery("getStateById" , StateEntity.class).setParameter("id", id).getSingleResult();
        }catch (NoResultException nre){
            return null;
        }
    }

}
