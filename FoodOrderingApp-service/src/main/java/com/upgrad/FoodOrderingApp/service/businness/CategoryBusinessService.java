package com.upgrad.FoodOrderingApp.service.businness;

import com.upgrad.FoodOrderingApp.service.dao.CategoryDao;
import com.upgrad.FoodOrderingApp.service.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;


@Service
public class CategoryBusinessService {

    @Autowired
    private CategoryDao categoryDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public Arrays getAllCategoryById(long restaurantId){
        return categoryDao.getCategoryById(restaurantId);
    }



}
