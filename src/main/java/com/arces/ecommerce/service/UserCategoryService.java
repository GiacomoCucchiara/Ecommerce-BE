package com.arces.ecommerce.service;

import java.util.List;

import javax.transaction.Transactional;

import com.arces.ecommerce.entity.UserCategory;
import com.arces.ecommerce.repository.UserCategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserCategoryService {
    
    @Autowired
    private UserCategoryRepository repo;

    public List<UserCategory> listAll() {
        return repo.findAll();
    }

    public void save(UserCategory userCard) {
        repo.save(userCard);

    }

    public void saveAll(List<UserCategory> userCards) {
        repo.saveAll(userCards);

    }

    public UserCategory get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
