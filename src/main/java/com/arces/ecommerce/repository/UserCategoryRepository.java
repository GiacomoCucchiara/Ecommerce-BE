package com.arces.ecommerce.repository;

import com.arces.ecommerce.entity.UserCategory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCategoryRepository extends JpaRepository<UserCategory, Long> {
    
}
