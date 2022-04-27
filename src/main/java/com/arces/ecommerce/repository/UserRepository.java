package com.arces.ecommerce.repository;

import java.util.List;

import com.arces.ecommerce.entity.User;
import com.arces.ecommerce.entity.UserCard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query(
        value="SELECT * FROM user u JOIN user_card uc ON u.user_id = uc.user_id AND u.user_id = :user_id",
        nativeQuery=true
    )
    public List<UserCard> getUserCard (@Param("user_id") Integer user_id);

    public User findByUsername(String username);
}