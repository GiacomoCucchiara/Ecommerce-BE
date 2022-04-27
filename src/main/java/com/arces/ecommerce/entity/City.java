package com.arces.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {
    @Column(name = "city_id")
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer city_id;
    @ManyToOne(optional=false) 
    @JoinColumn(name="country_id", nullable=false, updatable=false)
    private Country country;
    // private Integer country_id;
    private String name;
    private String province;
    

    public City() {
    }


   


    public City(Integer city_id, Country country, String name, String province) {
        this.city_id = city_id;
        this.country = country;
        this.name = name;
        this.province = province;
    }





    public Country getCountry() {
        return country;
    }





    public void setCountry(Country country) {
        this.country = country;
    }





    public Integer getCity_id() {
        return this.city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

}
