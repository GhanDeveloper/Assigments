package com.upgrad.FoodOrderingApp.service.dao;

import com.upgrad.FoodOrderingApp.service.entity.CategoryEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;

@Repository
public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Arrays getCategoryById(long restaurantId) {
        try {
           return (Arrays) entityManager.createNamedQuery("getAllCategoryById", CategoryEntity.class).setParameter("restaurantId", restaurantId).getResultList();

        } catch (NoResultException nre) {
            return null;
        }
    }
}
