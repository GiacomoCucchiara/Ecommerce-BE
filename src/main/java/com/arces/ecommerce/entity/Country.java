package com.arces.ecommerce.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

    @Column(name = "country_id")
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer country_id;
    private String name;
    private String iso2;
    private String iso3;
    private String currency;
    private String dialcode;
    private String flag;
    
    public Country() {
    }

    public Country(Integer country_id, String name, String iso2, String iso3, String currency, String dialcode,
            String flag) {
        this.country_id = country_id;
        this.name = name;
        this.iso2 = iso2;
        this.iso3 = iso3;
        this.currency = currency;
        this.dialcode = dialcode;
        this.flag = flag;
    }

    public Integer getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Integer country_id) {
        this.country_id = country_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDialcode() {
        return dialcode;
    }

    public void setDialcode(String dialcode) {
        this.dialcode = dialcode;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
    
    
    
}
