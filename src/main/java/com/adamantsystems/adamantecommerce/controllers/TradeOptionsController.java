package com.adamantsystems.adamantecommerce.controllers;

import com.adamantsystems.adamantecommerce.models.Product;
import com.adamantsystems.adamantecommerce.models.ProductEnumCategory;
import com.adamantsystems.adamantecommerce.repo.ProductRepository;
import com.adamantsystems.adamantecommerce.service.FileUploadUtil;
import com.adamantsystems.adamantecommerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class TradeOptionsController {

        @Autowired
        private ProductRepository productRepository;

        @Autowired
        private ProductService productService;

        @GetMapping("/add")
        public String Add(Model model){
            Product product = new Product();
            model.addAttribute("product",product);
            model.addAttribute("productEnumCategories",ProductEnumCategory.values());

            return "product-downloader";
        }
        @PostMapping("/add/product")
        public String AddProduct(@Valid Product product,BindingResult bindingResult, @RequestParam("image") MultipartFile multipartFile) throws IOException {

            if(bindingResult.hasErrors()){
               return "product-downloader";
           }

            if (!multipartFile.isEmpty()){
                String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
                product.setPhoto(fileName);
                Product savedProduct = productService.save(product);
                String upload = "src/main/resources/static/ProductImages/" + product.getId();
                FileUploadUtil.saveFile(upload,fileName,multipartFile);
            }else {
                if(product.getPhoto().isEmpty()){
                    product.setPhoto(null);
                }
            }
            productService.save(product);


            return "redirect:/add";
        }


        @GetMapping("/edit/product")
        public String productEdit(Model model) {
            Iterable<Product> productList = productRepository.findAll();
            model.addAttribute("productListEd", productList);
            return "product-edit";
        }


        @GetMapping("/edit/product/{id}")
        public String productDetailsEdit(@PathVariable(value = "id") long id, Model model){
            model.addAttribute(new Product());
            model.addAttribute("productEnumCategories",ProductEnumCategory.values());

            if(!productRepository.existsById(id)){
                return "redirect:/";
            }
            Optional<Product> productById = productRepository.findById(id);
            ArrayList<Product> res = new ArrayList<>();
            productById.ifPresent(res::add);
            model.addAttribute("productById",res);
            return "product-details-edit";
        }

        @PostMapping("/edit/product/{id}")
        public String EditAddProduct(@PathVariable(value = "id") long id,@RequestParam String name
                ,@RequestParam String details,@RequestParam double price){
            Product product = productRepository.findById(id).orElseThrow();
            product.setName(name);
            product.setDetails(details);
            product.setPrice(price);
            productRepository.save(product);
            return "trade-options";
        }
        @PostMapping("/edit/product/remove/{id}")
        public String EditAddProduct(@PathVariable(value = "id") long id, Model model){
            Product product = productRepository.findById(id).orElseThrow();
            productRepository.delete(product);
            return "trade-options";
    }
    }

