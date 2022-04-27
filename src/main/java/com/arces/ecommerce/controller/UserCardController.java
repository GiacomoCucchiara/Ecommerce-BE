package com.arces.ecommerce.controller;
// import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
// import java.util.Set;

import com.arces.ecommerce.entity.UserCard;
import com.arces.ecommerce.service.UserCardService;

// import org.springframework.beans.BeanUtils;
// import org.springframework.beans.BeanWrapper;
// import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserCardController {
    
    @Autowired
    private UserCardService service;

    @GetMapping("/userscard")
    public List<UserCard> list() {
        return service.listAll();
    }

    @GetMapping("/userscard/{user_card_id}")
    public ResponseEntity<UserCard> get(@PathVariable Long user_card_id) {

        try {
            UserCard user_card = service.get(user_card_id);
            return new ResponseEntity<UserCard>(user_card, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<UserCard>(HttpStatus.NOT_FOUND);
        }

        
    }


    @PostMapping("/userscard")
    public void add(@RequestBody UserCard user_card) {
        service.save(user_card);
    }

    @DeleteMapping("/userscard/{user_card_id}")
    public ResponseEntity<?> delete(@PathVariable Long user_card_id) {
        try {

            service.delete(user_card_id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // @PostMapping("/Users")
    // public void addAll(@RequestBody User[] User) {
        
    //     for (User p : User){
    //         service.save(p);
    //     }
    

    // }

    // @PutMapping("/Users/{User_id}")
    // public ResponseEntity<User> update(@RequestBody User User, @PathVariable Long User_id) {
    //     try {
    //         User User_old = service.get(User_id);
    //         copyNonNullProperties(User, User_old);
    //         service.save(User_old);
    //         return new ResponseEntity<>(HttpStatus.OK);

    //     } catch (NoSuchElementException e) {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    // }


    // public static void copyNonNullProperties(Object src, Object target) {
    //     BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    // }

    // public static String[] getNullPropertyNames(Object source) {
    //     final BeanWrapper src = new BeanWrapperImpl(source);
    //     java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

    //     Set<String> emptyNames = new HashSet<String>();
    //     for (java.beans.PropertyDescriptor pd : pds) {
    //         Object srcValue = src.getPropertyValue(pd.getName());
    //         if (srcValue == null)
    //             emptyNames.add(pd.getName());
    //     }
    //     String[] result = new String[emptyNames.size()];
    //     return emptyNames.toArray(result);
    // }
}