package com.upgrad.FoodOrderingApp.api.controller;

import com.upgrad.FoodOrderingApp.api.model.*;

import com.upgrad.FoodOrderingApp.service.businness.AddressBusinessService;
import com.upgrad.FoodOrderingApp.service.businness.CategoryBusinessService;
import com.upgrad.FoodOrderingApp.service.businness.RestaurantBusinessService;
import com.upgrad.FoodOrderingApp.service.businness.StateBusinesservice;
import com.upgrad.FoodOrderingApp.service.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


//RestController annotation specifies that this class represents a REST API(equivalent of @Controller + @ResponseBody)
@RestController
//"@CrossOrigin” annotation enables cross-origin requests for all methods in that specific controller class.
@CrossOrigin
@RequestMapping("/")
public class RestaurantController {

    @Autowired
    private RestaurantBusinessService restaurantBusinessService;

    @Autowired
    private AddressBusinessService addressBusinessService;

    @Autowired
    private StateBusinesservice stateBusinesservice;

    @Autowired
    private CategoryBusinessService categoryBusinessService;

    @RequestMapping(method = RequestMethod.GET, path = "/restaurant" , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<RestaurantDetailsResponse>> getAllRestaurant(){

        final List<RestaurantEntity> allRestaurant = restaurantBusinessService.getAllQuestion();


        List<RestaurantDetailsResponse> restaurantResponse = Restaurantlist(allRestaurant);

        return new ResponseEntity<List<RestaurantDetailsResponse>>(restaurantResponse, HttpStatus.OK);
    }

    public List<RestaurantDetailsResponse> Restaurantlist(List<RestaurantEntity> allRestaurant){
        List<RestaurantDetailsResponse> listofrestaurant = new ArrayList<>();
        List<CategoryList> categoryLists = new ArrayList<>();

        for ( RestaurantEntity restaurantEntity : allRestaurant){
            RestaurantDetailsResponse Response = new RestaurantDetailsResponse();
            Response.id(restaurantEntity.getUuid());
            Response.restaurantName(restaurantEntity.getRestaurantName());
            Response.photoURL(restaurantEntity.getPhotoUrl());
            Response.customerRating(restaurantEntity.getCustomerRating());
            Response.averagePrice(restaurantEntity.getAveragePriceForTwo());
            Response.numberCustomersRated(restaurantEntity.getNumberOfCustomersRated());
            AddressEntity addressEntity = addressBusinessService.getAddressById(restaurantEntity.getAddress().getId());

               RestaurantDetailsResponseAddress responseAddress = new RestaurantDetailsResponseAddress();
               responseAddress.id(UUID.fromString(addressEntity.getUuid()));
               responseAddress.flatBuildingName(addressEntity.getFlatBuilNumber());
               responseAddress.locality(addressEntity.getLocality());
               responseAddress.city(addressEntity.getCity());
               responseAddress.pincode(addressEntity.getPinCode());

            StateEntity stateEntity =  stateBusinesservice.getStateById(restaurantEntity.getAddress().getState().getId());

               RestaurantDetailsResponseAddressState responseAddressState = new RestaurantDetailsResponseAddressState();
               responseAddressState.id(UUID.fromString(stateEntity.getUuid()));
               responseAddressState.stateName(stateEntity.getStateName());
               responseAddress.state(responseAddressState);
               Response.address(responseAddress);



         /*  CategoryEntity categoryEntity = categoryBusinessService.getAllCategoryById(restaurantEntity.getId());
               CategoryList categoryList = new CategoryList();

               categoryList.id(UUID.fromString(categoryEntity.getUuid()));
               categoryList.categoryName(categoryEntity.getCategoryName());

              categoryLists.add(categoryList);


            Response.categories(categoryLists);*/

            listofrestaurant.add(Response);
        }
        return listofrestaurant;
    }
}
