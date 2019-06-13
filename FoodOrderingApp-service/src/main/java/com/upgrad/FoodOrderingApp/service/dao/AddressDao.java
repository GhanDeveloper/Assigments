package com.upgrad.FoodOrderingApp.service.dao;

import com.upgrad.FoodOrderingApp.service.entity.AddressEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AddressDao {

    @PersistenceContext
    private EntityManager entityManager;

    public AddressEntity getAddressById(long id){
        try {
            return entityManager.createNamedQuery("getAddressById" , AddressEntity.class).setParameter("id", id).getSingleResult();
        }catch (NoResultException nre){
            return null;
        }
    }
}
