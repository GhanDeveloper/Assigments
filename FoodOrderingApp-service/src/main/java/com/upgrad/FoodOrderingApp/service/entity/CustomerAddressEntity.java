package com.upgrad.FoodOrderingApp.service.entity;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(
        name = "customer_address"
)
/*@NamedQueries({@NamedQuery(
        name = "customerByContactNumber",
        query = "select c from CustomerEntity c where c.contactNumber = :contactNumber"
)
})*/
public class CustomerAddressEntity implements Serializable {

    @Id
    @Column(
            name = "ID"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;

    @ManyToOne
    @OnDelete(
            action = OnDeleteAction.CASCADE
    )
    @JoinColumn(
            name = "CUSTOMER_ID"
    )
    private CustomerEntity customer;

    @ManyToOne
    @OnDelete(
            action = OnDeleteAction.CASCADE
    )
    @JoinColumn(
            name = "ADDRESS_ID"
    )
    private AddressEntity address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }
}