package com.arces.ecommerce.city;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class City {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer city_id;
    private Long country_id;
    private String name;
    private String province;
    

    public City() {
    }


    public City(Integer city_id, Long country_id, String name, String province) {
        this.city_id = city_id;
        this.country_id = country_id;
        this.name = name;
        this.province = province;
    }


    public Integer getCity_id() {
        return this.city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public Long getCountry_id() {
        return this.country_id;
    }

    public void setCountry_id(Long country_id) {
        this.country_id = country_id;
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
