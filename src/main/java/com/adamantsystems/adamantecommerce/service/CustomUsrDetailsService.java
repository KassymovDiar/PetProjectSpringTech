package com.adamantsystems.adamantecommerce.service;

import com.adamantsystems.adamantecommerce.models.UserEntity;
import com.adamantsystems.adamantecommerce.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUsrDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User with email = " + email + " not exist!"));
        return new CustomUserDetails(user);
    }
}
