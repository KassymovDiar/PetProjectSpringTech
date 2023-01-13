package com.adamantsystems.adamantecommerce.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.text.DecimalFormat;
import java.text.NumberFormat;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2,message = "минимум 2 буквы")
    @NotBlank(message = "не заполнено")
    private String name;
    @Enumerated(EnumType.ORDINAL)
    private ProductEnumCategory category;
    @Column(length = 2000)
    @NotEmpty(message = "заполните описание")
    private String details;
    @Min(value = 1, message = "минимум 1")
    private double price;
    @Column(length = 10000)
    private String photo;

    public Product() {
    }

    public Product(String name, ProductEnumCategory category, String details, double price, String photo) {
        this.name = name;
        this.category = category;
        this.details = details;
        this.price = price;
        this.photo = photo;
    }

    public String priceFormat(){
        NumberFormat formatter = new DecimalFormat("#0.00 KZT");
        return formatter.format(price);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductEnumCategory getCategory() {
        return category;
    }

    public void setCategory(ProductEnumCategory category) {
        this.category = category;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;

    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", details='" + details + '\'' +
                ", price=" + price +
                ", photo='" + photo + '\'' +
                '}';
    }
}
