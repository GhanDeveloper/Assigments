package com.upgrad.FoodOrderingApp.service.dao;

import com.upgrad.FoodOrderingApp.service.entity.CategoryEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public CategoryEntity getCategoryById(long restaurantId) {
        try {
            return entityManager.createNamedQuery("getAllCategoryById", CategoryEntity.class).setParameter("restaurantId", restaurantId).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
