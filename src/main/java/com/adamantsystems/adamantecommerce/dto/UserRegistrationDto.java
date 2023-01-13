package com.adamantsystems.adamantecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegistrationDto {
    @Size(min = 2,message = "минимум 2 буквы")
    @NotBlank(message = "не заполнено")
    private String firstName;

    @Size(min = 2,message = "минимум 2 буквы")
    @NotBlank(message = "не заполнено")
    private String lastName;

    @Size(min = 2,message = "минимум 2 буквы")
    @NotBlank(message = "не заполнено")
    private String email;

    @Size(min = 4,message = "минимум 4 символа")
    @NotBlank(message = "не заполнено")
    private String password;

    public UserRegistrationDto() {
    }

    public UserRegistrationDto(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
