package com.adamantsystems.adamantecommerce.service;

import com.adamantsystems.adamantecommerce.dto.UserRegistrationDto;
import com.adamantsystems.adamantecommerce.models.UserEntity;


public interface UserService {
    UserEntity save(UserRegistrationDto registrationDto);



}
