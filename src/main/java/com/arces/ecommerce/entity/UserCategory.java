package com.arces.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_category")
public class UserCategory {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer user_category_id;
    private String category;
    
    public UserCategory() {
    }

    public UserCategory(Integer user_category_id, String category) {
        this.user_category_id = user_category_id;
        this.category = category;
    }

    public Integer getUser_category_id() {
        return user_category_id;
    }

    public void setUser_category_id(Integer user_category_id) {
        this.user_category_id = user_category_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    
    
}
