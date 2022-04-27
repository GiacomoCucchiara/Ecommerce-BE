package com.arces.ecommerce.service;

import java.util.ArrayList;

import com.arces.ecommerce.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        com.arces.ecommerce.entity.User user = userRepo.findByUsername(username);
        
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }


    
}
