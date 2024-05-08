package com.crud.pokemon.controller;

import com.crud.pokemon.model.dto.users.UpdateDTO;
import com.crud.pokemon.model.dto.users.UserDTO;
import com.crud.pokemon.service.user.UserService;
import jakarta.servlet.http.HttpServletRequest;
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
    public ResponseEntity<List<UserDTO>> getAllUsers(HttpServletRequest request) {
        var registrationDTOList = userService.getAllUsers();
        return ResponseEntity.ok(registrationDTOList);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> findById(@PathVariable String username, HttpServletRequest request) {
        UserDTO user = userService.findByUsername(username);
        return ResponseEntity.ok(user);
    }

    @PutMapping
    public ResponseEntity<UpdateDTO> updateUser(@RequestBody UpdateDTO data, HttpServletRequest request) {
        userService.updateUser(data);
        return ResponseEntity.ok(new UpdateDTO(data.name(), data.username(), data.password()));
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username, HttpServletRequest request) {
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }
}
