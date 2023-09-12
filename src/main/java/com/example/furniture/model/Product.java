package com.example.furniture.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Table(name = "products")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    private String name;
    private Double price;
    private String description;

    private Integer categoryId;
    private String colorsList;
    private String imagesList;

    @Column(name = "created_at")
    private Date createdAt;

    public Product(String name, Double price, String description, Integer categoryId, String colorsList, String imagesList, Date createdAt) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
        this.colorsList = colorsList;
        this.imagesList = imagesList;
        this.createdAt = createdAt;
    }

    public Product(Long productId, String name, Double price, String description, Integer categoryId, String colorsList, String imagesList, Date createdAt) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
        this.colorsList = colorsList;
        this.imagesList = imagesList;
        this.createdAt = createdAt;
    }

    public Product() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getColorsList() {
        return colorsList;
    }

    public void setColorsList(String colorsList) {
        this.colorsList = colorsList;
    }

    public String getImagesList() {
        return imagesList;
    }

    public void setImagesList(String imagesList) {
        this.imagesList = imagesList;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", categoryId=" + categoryId +
                ", colorsList='" + colorsList + '\'' +
                ", imagesList='" + imagesList + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}

