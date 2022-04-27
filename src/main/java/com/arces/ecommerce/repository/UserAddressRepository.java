package com.arces.ecommerce.repository;

import com.arces.ecommerce.entity.UserAddress;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {

}
