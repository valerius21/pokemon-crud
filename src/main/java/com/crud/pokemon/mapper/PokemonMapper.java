package com.crud.pokemon.mapper;

import com.crud.pokemon.model.Pokemon;
import com.crud.pokemon.model.dto.pokemon.PokemonRequestDTO;
import com.crud.pokemon.model.dto.pokemon.PokemonResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PokemonMapper {

    private final ModelMapper mapper;

    public PokemonMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Pokemon toEntity(PokemonRequestDTO request) {
        return mapper.map(request, Pokemon.class);
    }

    public PokemonResponseDTO entityToDto(Pokemon data) {
        return mapper.map(data, PokemonResponseDTO.class);
    }

    public List<PokemonResponseDTO> listEntityToListDTO(List<Pokemon> data) {
        return data.stream().map(this::entityToDto).toList();
    }
}
