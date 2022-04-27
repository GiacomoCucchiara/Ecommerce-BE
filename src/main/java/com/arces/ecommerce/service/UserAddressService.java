package com.arces.ecommerce.service;

import java.util.List;
import javax.transaction.Transactional;

import com.arces.ecommerce.entity.UserAddress;
import com.arces.ecommerce.repository.UserAddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class UserAddressService {

    @Autowired
    private UserAddressRepository repo;

    public List<UserAddress> listAll() {
        return repo.findAll();
    }

    public void save(UserAddress useAddress) {
        repo.save(useAddress);

    }

    public void saveAll(List<UserAddress> userAddress) {
        repo.saveAll(userAddress);

    }

    public UserAddress get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
    
}


