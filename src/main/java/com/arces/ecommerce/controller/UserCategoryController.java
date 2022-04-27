package com.arces.ecommerce.controller;

import java.util.List;
import java.util.NoSuchElementException;

import com.arces.ecommerce.entity.UserCategory;
import com.arces.ecommerce.service.UserCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class UserCategoryController {
    
    @Autowired
    private UserCategoryService service;

    @GetMapping("/userscategory")
    public List<UserCategory> list() {
        return service.listAll();
    }

    @GetMapping("/userscategory/{user_category_id}")
    public ResponseEntity<UserCategory> get(@PathVariable Long user_category_id) {

        try {
            UserCategory user_card = service.get(user_category_id);
            return new ResponseEntity<UserCategory>(user_card, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<UserCategory>(HttpStatus.NOT_FOUND);
        }

        
    }


    @PostMapping("/userscategory")
    public void add(@RequestBody UserCategory user_card) {
        service.save(user_card);
    }

    @DeleteMapping("/userscategory/{user_category_id}")
    public ResponseEntity<?> delete(@PathVariable Long user_category_id) {
        try {

            service.delete(user_category_id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
