package com.upgrad.FoodOrderingApp.service.businness;

import com.upgrad.FoodOrderingApp.service.dao.StateDao;
import com.upgrad.FoodOrderingApp.service.entity.StateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class StateBusinesservice {

    @Autowired
    private StateDao stateDao;


    @Transactional(propagation = Propagation.REQUIRED)
    public StateEntity getStateById(long id){
        return stateDao.getStateById(id);
    }
}
