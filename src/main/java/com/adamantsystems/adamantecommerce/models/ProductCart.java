package com.adamantsystems.adamantecommerce.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Component
@SessionScope
public class ProductCart {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
    private Set<Product> templeProdCart =new HashSet<>();
    public void add(Product product){
        templeProdCart.add(product);
    }
    public void clear(){
        templeProdCart.clear();
    }

    public ProductCart() {
    }

    public Set<Product> getTempleProdCart() {
        return templeProdCart;
    }

    public void setTempleProdCart(Set<Product> templeProdCart) {
        this.templeProdCart = templeProdCart;
    }


}
