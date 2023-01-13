package com.adamantsystems.adamantecommerce.controllers;

import com.adamantsystems.adamantecommerce.dto.UserRegistrationDto;
import com.adamantsystems.adamantecommerce.models.UserEntity;
import com.adamantsystems.adamantecommerce.repo.UserRepository;
import com.adamantsystems.adamantecommerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private UserService userService;
    @Autowired
    private UserRepository userRepo;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }


    @GetMapping
    public String showRegistrationForm(Model model){
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
        model.addAttribute("user",userRegistrationDto);
        System.out.println(" GET userRegistrationDto = " + userRegistrationDto.getFirstName());
        return "registration-form";
    }
    @PostMapping
    public String registerUserAccount(@Valid @ModelAttribute("user") UserRegistrationDto userRegistrationDto, BindingResult result){

        if(result.hasErrors()){
            System.out.println("if(result.hasErrors() =" + result.hasErrors());
            return "registration-form";
        }

        Optional<UserEntity> existingUser = userRepo.findByEmail(userRegistrationDto.getEmail());
        if (!existingUser.isEmpty()) {
            return "redirect:/registration?error";
        }
        userService.save(userRegistrationDto);
            return "redirect:/registration?success";
        }

    }



