package com.crud.pokemon.model.dto.users;

public record LoginResponseDTO(
        String username,
        String token
) {
}
