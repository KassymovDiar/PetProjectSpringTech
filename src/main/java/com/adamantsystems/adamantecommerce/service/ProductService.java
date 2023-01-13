package com.adamantsystems.adamantecommerce.service;

import com.adamantsystems.adamantecommerce.models.Product;
import com.adamantsystems.adamantecommerce.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product){
        return productRepository.save(product);
    }
}
