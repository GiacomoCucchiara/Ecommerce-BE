package com.arces.ecommerce.repository;

import com.arces.ecommerce.entity.UserCard;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCardRepository extends JpaRepository<UserCard, Long> {

}