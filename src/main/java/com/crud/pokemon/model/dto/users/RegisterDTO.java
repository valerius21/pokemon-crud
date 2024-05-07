package com.crud.pokemon.model.dto.users;

import com.crud.pokemon.model.enums.Role;

public record RegisterDTO(String name, String username, String password, Role role) {
}
