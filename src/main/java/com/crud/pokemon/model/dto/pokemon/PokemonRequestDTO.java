package com.crud.pokemon.model.dto.pokemon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PokemonRequestDTO {

    private String name;
    private String category;
    private String abilities;

    private String type;
    private String weakness;

    private String height;
    private String weight;

}
