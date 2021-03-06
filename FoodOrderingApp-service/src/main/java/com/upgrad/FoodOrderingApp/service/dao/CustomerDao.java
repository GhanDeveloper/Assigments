package com.upgrad.FoodOrderingApp.service.dao;

import com.upgrad.FoodOrderingApp.service.entity.CustomerAuthTokenEntity;
import com.upgrad.FoodOrderingApp.service.entity.CustomerEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class CustomerDao {
    @PersistenceContext
    private EntityManager entityManager;


    //saves the customer information of the created customer in the database
    public CustomerEntity createCustomer(CustomerEntity customerEntity) {
        this.entityManager.persist(customerEntity);
        return customerEntity;
    }

    public CustomerEntity getCustomerByContactNumber(String contactNumber) {
        try {
            return (CustomerEntity)this.entityManager.createNamedQuery("customerByContactNumber", CustomerEntity.class).setParameter("contactNumber", contactNumber).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public CustomerAuthTokenEntity createAuthToken(CustomerAuthTokenEntity customerAuthTokenEntity) {
        this.entityManager.persist(customerAuthTokenEntity);
        return customerAuthTokenEntity;
    }

    public void updateCustomer(CustomerEntity updatedCustomerEntity) {
    this.entityManager.merge(updatedCustomerEntity);
   }

    public CustomerAuthTokenEntity getCustomerAuthToken(final String accessToken) {
        try {
            return entityManager.createNamedQuery("customerAuthTokenByAccessToken", CustomerAuthTokenEntity.class).setParameter("accessToken", accessToken).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }


}
