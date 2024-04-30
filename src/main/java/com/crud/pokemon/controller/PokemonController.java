package com.crud.pokemon.controller;

import com.crud.pokemon.model.dto.pokemon.PokemonRequestDTO;
import com.crud.pokemon.model.dto.pokemon.PokemonResponseDTO;
import com.crud.pokemon.service.pokemon.PokemonServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pokemon")
public class PokemonController {

    private final PokemonServiceImpl service;

    public PokemonController(PokemonServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PokemonResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findALl());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/findByAll")
    public ResponseEntity<List<PokemonResponseDTO>> findByKeyword(
            @RequestParam(required = false) String keyword
            ) {
        return ResponseEntity.ok(service.findByKeyword(keyword));
    }

    @PostMapping
    public ResponseEntity<PokemonResponseDTO> save(@RequestBody PokemonRequestDTO pokemon) {
        return ResponseEntity.ok(service.save(pokemon));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PokemonResponseDTO> update(@PathVariable Long id, @RequestBody PokemonRequestDTO pokemon) {
        return ResponseEntity.ok(service.update(id, pokemon));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
