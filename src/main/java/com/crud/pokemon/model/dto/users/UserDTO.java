package com.crud.pokemon.model.dto.users;

import com.crud.pokemon.model.Pokemon;
import com.crud.pokemon.model.enums.Role;

import java.util.Set;

public record UserDTO(
        Long id,
        String name,
        String username,
        String password,
        Role role,
        Set<Pokemon> wishlist
) {
}
