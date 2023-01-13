package com.adamantsystems.adamantecommerce.controllers;

import com.adamantsystems.adamantecommerce.models.Product;
import com.adamantsystems.adamantecommerce.models.ProductCart;
import com.adamantsystems.adamantecommerce.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Set;

@Controller
public class ProductCartController {
    @Autowired
    ProductRepository productRepository;

    private final ProductCart productCart;

    public ProductCartController(ProductCart productCart) {
        this.productCart = productCart;
    }

    @GetMapping("/cart")
    public String get(Model model){
        Set<Product> products = productCart.getTempleProdCart();

        model.addAttribute("products",products);
        model.addAttribute("product",new Product());
        return "cart";
    }

    @GetMapping("/cart/{id}")
    public String add(@PathVariable(value = "id") long id, Model model){

        if(!productRepository.existsById(id)){
            return "redirect:/";
        }
        Product productById = productRepository.getProductById(id);
        productCart.add(productById);
        return "redirect:/";
    }

}
