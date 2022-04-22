package com.arces.ecommerce.users;

import java.security.Timestamp;
// import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
// import java.util.Set;

import com.arces.ecommerce.useraddress.UserAddress;
import com.arces.ecommerce.useraddress.UserAddressService;
import com.arces.ecommerce.usercard.UserCard;
import com.arces.ecommerce.usercard.UserCardService;

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
public class UserController {

    @Autowired
    private UserService service;
    @Autowired
    private UserCardService servicecard;
    @Autowired
    private UserAddressService serviceaddress;

    @GetMapping("/users")
    public List<User> list() {
        return service.listAll();
    }

    @GetMapping("/users/{user_id}")
    public ResponseEntity<User> get(@PathVariable Long user_id) {

        try {
            User user = service.get(user_id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/users")
    public ResponseEntity<?> add(@RequestBody User user) {
        try {
        List<UserCard> user_cards = user.getUser_cards();
        List<UserAddress> user_address = user.getUser_address();

        Long user_id = user.getUser_id();
        user.setActive(1);
        if (user.getUser_category_id() == null){
            user.setUser_category_id(1);
        }
        user.setCreate_date(new java.sql.Timestamp(System.currentTimeMillis()));
        user.setLast_activity(user.getCreate_date());
        service.save(user);

        if (user_cards != null) {
            if (!user_cards.isEmpty()) {
                for (UserCard userCard : user_cards) {
                    userCard.setUser_id(user_id);
                }
                servicecard.saveAll(user_cards);
            }
        }
        if (user_address != null) {
            if (!user_address.isEmpty()) {
                for (UserAddress userAddress : user_address) {
                    userAddress.setUser_id(user_id);
                }
                serviceaddress.saveAll(user_address);
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<String>("User/Email alredy used", HttpStatus.FORBIDDEN);
    }
    }

    @DeleteMapping("/users/{user_id}")
    public ResponseEntity<?> delete(@PathVariable Long user_id) {
        try {

            service.delete(user_id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @PostMapping("/Users")
    // public void addAll(@RequestBody User[] User) {

    // for (User p : User){
    // service.save(p);
    // }

    // }

    // @PutMapping("/Users/{User_id}")
    // public ResponseEntity<User> update(@RequestBody User User, @PathVariable Long
    // User_id) {
    // try {
    // User User_old = service.get(User_id);
    // copyNonNullProperties(User, User_old);
    // service.save(User_old);
    // return new ResponseEntity<>(HttpStatus.OK);

    // } catch (NoSuchElementException e) {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
    // }

    // public static void copyNonNullProperties(Object src, Object target) {
    // BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    // }

    // public static String[] getNullPropertyNames(Object source) {
    // final BeanWrapper src = new BeanWrapperImpl(source);
    // java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

    // Set<String> emptyNames = new HashSet<String>();
    // for (java.beans.PropertyDescriptor pd : pds) {
    // Object srcValue = src.getPropertyValue(pd.getName());
    // if (srcValue == null)
    // emptyNames.add(pd.getName());
    // }
    // String[] result = new String[emptyNames.size()];
    // return emptyNames.toArray(result);
    // }
}