package com.crud.pokemon.service.pokemon;

import com.crud.pokemon.model.dto.pokemon.PokemonRequestDTO;
import com.crud.pokemon.model.dto.pokemon.PokemonResponseDTO;

import java.util.List;

public interface PokemonService {

    List<PokemonResponseDTO> findALl();
    PokemonResponseDTO findById(Long id);
    List<PokemonResponseDTO> findByKeyword(String keyword);
    PokemonResponseDTO save(PokemonRequestDTO pokemon);
    PokemonResponseDTO update(Long id, PokemonRequestDTO pokemon);
    void delete(Long id);
    void favorite(Long id);
    void unFavorite(Long id);
}
