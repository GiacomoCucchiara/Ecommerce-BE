package com.arces.ecommerce.controller;
// import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
// import java.util.Set;

import com.arces.ecommerce.entity.UserAddress;
import com.arces.ecommerce.service.UserAddressService;

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
public class UserAddressController {
    
    @Autowired
    private UserAddressService service;

    @GetMapping("/usersaddress")
    public List<UserAddress> list() {
        return service.listAll();
    }

    @GetMapping("/usersaddress/{usersaddress_id}")
    public ResponseEntity<UserAddress> get(@PathVariable Long usersaddress_id) {

        try {
            UserAddress user_address = service.get(usersaddress_id);
            return new ResponseEntity<UserAddress>(user_address, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<UserAddress>(HttpStatus.NOT_FOUND);
        }

        
    }


    @PostMapping("/usersaddress")
    public void add(@RequestBody UserAddress user_address) {
        service.save(user_address);
    }

    @DeleteMapping("/usersaddress/{usersaddress_id}")
    public ResponseEntity<?> delete(@PathVariable Long usersaddress_id) {
        try {

            service.delete(usersaddress_id);
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