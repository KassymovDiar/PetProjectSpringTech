package com.adamantsystems.adamantecommerce.controllers;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {
        private final AuthenticationManager authManager;
        private final UserDetailsService usrDetailsService;

        public AuthController( AuthenticationManager authManager,
                               UserDetailsService usrDetailsService) {
            super();
            this.authManager = authManager;
            this.usrDetailsService = usrDetailsService;
        }

        record LoginRequest(String username, String password) {}
        record LoginResponse(String message) {}

        @PostMapping("/login")
        public LoginResponse login(@RequestBody LoginRequest request) {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(request.username, request.password);
            Authentication auth = authManager.authenticate(authenticationToken);
            UserDetails user = usrDetailsService.loadUserByUsername(request.username);
            return new LoginResponse("User with email = "+ request.username + " successfully loggined!");
        }
}
