package com.arces.ecommerce.usercard;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user_card")
public class UserCard {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long user_card_id;
    private Long user_id;
    private String card_number;
    private String owner_name;
    private Date expiration;

    public UserCard() {
    }
<<<<<<< HEAD

=======
>>>>>>> 18c689aeae3cdc53b9e4005e721d0b5e4b79e658

    public UserCard(Long user_card_id, Long user_id, String card_number, String owner_name, Date expiration) {
        this.user_card_id = user_card_id;
        this.user_id = user_id;
        this.card_number = card_number;
        this.owner_name = owner_name;
        this.expiration = expiration;
    }

<<<<<<< HEAD
=======
    public Long getUser_card_id() {
        return user_card_id;
    }

    public void setUser_card_id(Long user_card_id) {
        this.user_card_id = user_card_id;
    }

>>>>>>> 18c689aeae3cdc53b9e4005e721d0b5e4b79e658
    public Long getUser_id() {
        return this.user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

<<<<<<< HEAD

    public Long getUser_card_id() {
        return user_card_id;
    }

    public void setUser_card_id(Long user_card_id) {
        this.user_card_id = user_card_id;
    }

=======
>>>>>>> 18c689aeae3cdc53b9e4005e721d0b5e4b79e658
    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

<<<<<<< HEAD
=======
   

>>>>>>> 18c689aeae3cdc53b9e4005e721d0b5e4b79e658
}
