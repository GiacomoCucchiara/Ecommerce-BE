package com.arces.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_address")
public class UserAddress {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long user_address_id;
    private Long user_id;
    private String full_name;
    @OneToOne(optional = false)
    @JoinColumn(
        name="city_id", unique=true, nullable=false, updatable=false)
    private City city;
    // private Integer city_id;
    private String address;
    private Integer postcode;
    private String phone;
    private String delivery_instructions;

    public UserAddress() {
    }

   

    


    public UserAddress(Long user_address_id, Long user_id, String full_name, City city, String address,
            Integer postcode, String phone, String delivery_instructions) {
        this.user_address_id = user_address_id;
        this.user_id = user_id;
        this.full_name = full_name;
        this.city = city;
        this.address = address;
        this.postcode = postcode;
        this.phone = phone;
        this.delivery_instructions = delivery_instructions;
    }






    public City getCity() {
        return city;
    }






    public void setCity(City city) {
        this.city = city;
    }






    public Long getUser_address_id() {
        return this.user_address_id;
    }

    public void setUser_address_id(Long user_address_id) {
        this.user_address_id = user_address_id;
    }

    public Long getUser_id() {
        return this.user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getFull_name() {
        return this.full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPostcode() {
        return this.postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDelivery_instructions() {
        return this.delivery_instructions;
    }

    public void setDelivery_instructions(String delivery_instructions) {
        this.delivery_instructions = delivery_instructions;
    }

}