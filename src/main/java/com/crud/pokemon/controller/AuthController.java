package com.crud.pokemon.controller;

import com.crud.pokemon.model.dto.users.AuthenticationDTO;
import com.crud.pokemon.model.dto.users.RegisterDTO;
import com.crud.pokemon.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegisterDTO data) {
        return userService.register(data);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody AuthenticationDTO authenticationDTO) {
        return userService.login(authenticationDTO);
    }

}
