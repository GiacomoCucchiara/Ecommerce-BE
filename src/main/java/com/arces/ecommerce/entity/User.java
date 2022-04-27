package com.arces.ecommerce.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long user_id;
    private String username;
    private String email;
    private String password;
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_category_id")
    private UserCategory category;
    // @Column(name = "user_category_id")
    // private Integer user_category_id;
    @OneToMany(mappedBy = "user_id")
    private List<UserCard> user_cards;
    @OneToMany(mappedBy = "user_id")
    private List<UserAddress> user_address;
    private String first_name;
    private String last_name;
    private String phone;
    private String sex;
    private Date birthday;
    private String business_name;
    private String vat_number;
    private Integer active;
    private Timestamp create_date;
    private Timestamp last_activity;

    public User() {
    }

    
  
    public User(Long user_id, String username, String email, String password, UserCategory category,
            List<UserCard> user_cards, List<UserAddress> user_address, String first_name, String last_name,
            String phone, String sex, Date birthday, String business_name, String vat_number, Integer active,
            Timestamp create_date, Timestamp last_activity) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.category = category;
        this.user_cards = user_cards;
        this.user_address = user_address;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.sex = sex;
        this.birthday = birthday;
        this.business_name = business_name;
        this.vat_number = vat_number;
        this.active = active;
        this.create_date = create_date;
        this.last_activity = last_activity;
    }



    public UserCategory getCategory() {
        return category;
    }



    public void setCategory(UserCategory category) {
        this.category = category;
    }



    public List<UserAddress> getUser_address() {
        return this.user_address;
    }

    public void setUser_address(List<UserAddress> user_address) {
        this.user_address = user_address;
    }

    public List<UserCard> getUser_cards() {
        return user_cards;
    }

    public void setUser_cards(List<UserCard> user_cards) {
        this.user_cards = user_cards;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public String getVat_number() {
        return vat_number;
    }

    public void setVat_number(String vat_number) {
        this.vat_number = vat_number;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public Timestamp getLast_activity() {
        return last_activity;
    }

    public void setLast_activity(Timestamp last_activity) {
        this.last_activity = last_activity;
    }

}
