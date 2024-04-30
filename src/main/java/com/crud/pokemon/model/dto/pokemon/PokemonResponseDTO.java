package com.crud.pokemon.model.dto.pokemon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PokemonResponseDTO {

    private Long id;
    private String name;
    private String abilities;

    public PokemonResponseDTO(PokemonRequestDTO pokemon) {
        this.name = pokemon.getName();
        this.abilities = pokemon.getAbilities();
    }
}
