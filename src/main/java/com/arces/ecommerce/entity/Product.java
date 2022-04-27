package com.arces.ecommerce.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    private  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long product_id;
    private String title;
    private Float price;
    private Integer stock;
    private Long store_id;
    private Integer vat_id;
    private Integer default_image_id;
    private Integer discount_id;
    private String image;
    private String description;
    private Integer active;
    private Timestamp create_date;
    
    public Product() {
    }

    public Product(Long product_id, String title, Float price, Integer stock, Long store_id, Integer vat_id,
            Integer default_image_id, Integer discount_id, String image, String description,
            Integer active, Timestamp create_date) {
        this.product_id = product_id;
        this.title = title;
        this.price = price;
        this.stock = stock;
        this.store_id = store_id;
        this.vat_id = vat_id;
        this.default_image_id = default_image_id;
        this.discount_id = discount_id;
        this.image = image;
        this.description = description;
        this.active = active;
        this.create_date = create_date;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Long getStore_id() {
        return store_id;
    }

    public void setStore_id(Long store_id) {
        this.store_id = store_id;
    }

    public Integer getVat_id() {
        return vat_id;
    }

    public void setVat_id(Integer vat_id) {
        this.vat_id = vat_id;
    }

    public Integer getDefault_image_id() {
        return default_image_id;
    }

    public void setDefault_image_id(Integer default_image_id) {
        this.default_image_id = default_image_id;
    }

    public Integer getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(Integer discount_id) {
        this.discount_id = discount_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    
    }
