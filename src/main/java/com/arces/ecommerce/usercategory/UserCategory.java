package com.arces.ecommerce.usercategory;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.arces.ecommerce.users.User;

@Entity
@Table(name = "user_category")
public class UserCategory {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer user_category_id;
    private String category;
    @OneToMany(mappedBy = "user_category_id")
    private List<User> user;
    
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
