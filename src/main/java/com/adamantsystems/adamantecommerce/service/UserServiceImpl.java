package com.adamantsystems.adamantecommerce.service;
import com.adamantsystems.adamantecommerce.dto.UserRegistrationDto;
import com.adamantsystems.adamantecommerce.models.RoleEntity;
import com.adamantsystems.adamantecommerce.models.UserEntity;
import com.adamantsystems.adamantecommerce.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Arrays;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }
    /* ***************  Для регистрации admin используйте логин= admin@gmail.com
     пароль= admin роль указывается ниже в коде ADMIN либо USER *************** */
    @Override
    public UserEntity save(UserRegistrationDto registrationDto) {
        UserEntity userEntity = new UserEntity(registrationDto.getFirstName(), registrationDto.getLastName()
                , registrationDto.getEmail(), passwordEncoder.encode(registrationDto.getPassword())
                , Arrays.asList(new RoleEntity("USER")));
        return userRepository.save(userEntity);
    }
}


