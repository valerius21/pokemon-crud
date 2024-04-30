package com.crud.pokemon.service.pokemon;

import com.crud.pokemon.exceptions.EntityNotFoundException;
import com.crud.pokemon.mapper.PokemonMapper;
import com.crud.pokemon.model.Pokemon;
import com.crud.pokemon.model.dto.pokemon.PokemonRequestDTO;
import com.crud.pokemon.model.dto.pokemon.PokemonResponseDTO;
import com.crud.pokemon.repository.PokemonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class PokemonServiceImpl implements PokemonService {

    private final PokemonRepository repository;
    private final PokemonMapper mapper;

    public PokemonServiceImpl(PokemonRepository repository, PokemonMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PokemonResponseDTO> findALl() {

        List<Pokemon> data = repository.findAll();
        List<PokemonResponseDTO> responses = mapper.listEntityToListDTO(data);

        log.info("Finding all Pokemon!");
        return responses;
    }

    @Override
    @Transactional(readOnly = true)
    public PokemonResponseDTO findById(Long id) {

        Pokemon data = repository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("id:%s not found", id)));
        PokemonResponseDTO response = mapper.entityToDto(data);

        log.info("Finding a pokemon by his id!");

        return response;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PokemonResponseDTO> findByKeyword(String keyword) {

        List<Pokemon> data = repository.findByKeyword(keyword);
        List<PokemonResponseDTO> response = mapper.listEntityToListDTO(data);
        log.info("Finding a pokemon by his name/category/abilities");

        return response;
    }

    @Override
    @Transactional
    public PokemonResponseDTO save(PokemonRequestDTO request) {
        Pokemon data = mapper.toEntity(request);
        PokemonResponseDTO response = mapper.entityToDto(repository.save(data));
        log.info("Saving a pokemon!");
        return response;
    }

    @Override
    @Transactional
    public PokemonResponseDTO update(Long id, PokemonRequestDTO pokemon) {

        Pokemon data = repository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("id:%s not found", id)));
        data.returner(pokemon);
        PokemonResponseDTO response = mapper.entityToDto(repository.save(data));
        log.info("Updating a pokemon!");

        return response;

    }

    @Override
    @Transactional
    public void delete(Long id) {
        this.findById(id);
        this.repository.deleteById(id);
        log.info("Deleting a pokemon!");
    }
}
