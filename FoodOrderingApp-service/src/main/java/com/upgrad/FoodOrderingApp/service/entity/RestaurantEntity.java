package com.upgrad.FoodOrderingApp.service.entity;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.UUID;

@Entity
@Table(name = "restaurant")
@NamedQueries({
        /*@NamedQuery(
         name = "customerByContactNumber",
         query = "select c from CustomerEntity c where c.contactNumber = :contactNumber"
        )*/
        @NamedQuery(name = "getAllRestaurant" , query = "select r from RestaurantEntity r order by r.customerRating desc ")
 })

public class RestaurantEntity implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "UUID")
    @Size(max = 200)
    private UUID uuid;

    @Column(name = "RESTAURANT_NAME")
    @NotNull
    @Size(max = 50)
    private String restaurantName;

    @Column(name = "PHOTO_URL")
    //photoUrl can be NULL
    private String photoUrl;

    @Column(name="CUSTOMER_RATING")
    @NotNull
    private BigDecimal customerRating;

    @Column(name = "AVERAGE_PRICE_FOR_TWO")
    @NotNull
    private Integer averagePriceForTwo;

    @Column(name = "NUMBER_OF_CUSTOMERS_RATED")
    @NotNull
    private Integer numberOfCustomersRated;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ADDRESS_ID")
    private AddressEntity address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public BigDecimal getCustomerRating() {
        return customerRating;
    }

    public void setCustomerRating(BigDecimal customerRating) {
        this.customerRating = customerRating;
    }

    public Integer getAveragePriceForTwo() {
        return averagePriceForTwo;
    }

    public void setAveragePriceForTwo(Integer averagePriceForTwo) {
        this.averagePriceForTwo = averagePriceForTwo;
    }

    public Integer getNumberOfCustomersRated() {
        return numberOfCustomersRated;
    }

    public void setNumberOfCustomersRated(Integer numberOfCustomersRated) {
        this.numberOfCustomersRated = numberOfCustomersRated;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }
}
