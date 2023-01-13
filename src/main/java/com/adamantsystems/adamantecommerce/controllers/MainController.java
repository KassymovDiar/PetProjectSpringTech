package com.adamantsystems.adamantecommerce.controllers;

import com.adamantsystems.adamantecommerce.models.Product;
import com.adamantsystems.adamantecommerce.models.ProductEnumCategory;
import com.adamantsystems.adamantecommerce.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public String home(Model model){
        Iterable<Product> productList = productRepository.findAll();
        model.addAttribute("productList",productList);
        return "home";
    }

    @GetMapping("/sort/{category}")
    public String homeCategory(@PathVariable(value = "category") ProductEnumCategory category, Model model){
        if(!productRepository.existsByCategory(category)){
            return "redirect:/";
        }
        Iterable<Product> productList = productRepository.findAllByCategory(category);
        model.addAttribute("productList",productList);
        return "home";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/trade-options")
    public String tradeOptions(){
        return "trade-options";
    }

    @GetMapping("/contacts")
    public String contactPage(){
        return "contacts";
    }

    @GetMapping("/product/{id}")
    public String productDetails(@PathVariable(value = "id") long id, Model model){
        if(!productRepository.existsById(id)){
            return "redirect:/";
        }
        Optional<Product> productById = productRepository.findById(id);
        ArrayList<Product> res = new ArrayList<>();
        productById.ifPresent(res::add);
        model.addAttribute("productById",res);
        return "product-details";
    }

}
