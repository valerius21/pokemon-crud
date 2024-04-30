package com.crud.pokemon.model.dto.pokemon;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PokemonRequestDTO {

    @NotBlank(message = "Name must not be blank!")
    @Size(min = 4, max = 30, message = "Name must be between 4 and 20 characters")
    private String name;

    @NotBlank(message = "Category must not be blank!")
    @Size(min = 4, max = 30, message = "Category must be between 4 and 20 characters")
    private String category;

    @NotBlank(message = "Abilities must not be blank!")
    @Size(min = 4, max = 30, message = "Abilities must be between 4 and 20 characters")
    private String abilities;

    @NotBlank(message = "Type must not be blank!")
    @Size(min = 4, max = 30, message = "Type must be between 4 and 20 characters")
    private String type;
    private String weakness;

    private String height;
    private String weight;

}
