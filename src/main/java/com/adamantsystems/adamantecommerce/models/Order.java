package com.adamantsystems.adamantecommerce.models;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date = new Date();
    @Column(name = "order_name")
    private String order_name;
    @Column(name = "order_lastname")
    private String order_lastname;
    @Column(name = "order_email")
    private String order_email;
    @Column(name = "order_address")
    private String order_address;
    @Column(name = "order_phone")
    private String order_phone;

    @OneToMany
    @JoinColumn(name="order_id")
    private Set<Product> productsToBuy =new HashSet<>();


    public String formatDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatter.format(date);
    }
    public Order() {
    }

    public Order(String order_name, String order_lastname, String order_email, String order_address, String order_phone, Set<Product> order_products) {
        this.order_name = order_name;
        this.order_lastname = order_lastname;
        this.order_email = order_email;
        this.order_address = order_address;
        this.order_phone = order_phone;
        this.productsToBuy = order_products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public String getOrder_lastname() {
        return order_lastname;
    }

    public void setOrder_lastname(String order_lastname) {
        this.order_lastname = order_lastname;
    }

    public String getOrder_email() {
        return order_email;
    }

    public void setOrder_email(String order_email) {
        this.order_email = order_email;
    }

    public String getOrder_address() {
        return order_address;
    }

    public void setOrder_address(String order_address) {
        this.order_address = order_address;
    }

    public String getOrder_phone() {
        return order_phone;
    }

    public void setOrder_phone(String order_phone) {
        this.order_phone = order_phone;
    }

    public Set<Product> getProductsToBuy() {
        return productsToBuy;
    }

    public void setProductsToBuy(Set<Product> order_products) {
        this.productsToBuy = order_products;
    }


}
