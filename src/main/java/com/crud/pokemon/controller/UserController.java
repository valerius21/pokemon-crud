package com.crud.pokemon.controller;

import com.crud.pokemon.model.dto.users.UpdateDTO;
import com.crud.pokemon.model.dto.users.UserDTO;
import com.crud.pokemon.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        var registrationDTOList = userService.getAllUsers();
        return ResponseEntity.ok(registrationDTOList);
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@RequestBody UpdateDTO updateDTO) {
        userService.updateUser(updateDTO);
        return ResponseEntity.ok("Updated!");
    }

    @DeleteMapping("{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }
}
