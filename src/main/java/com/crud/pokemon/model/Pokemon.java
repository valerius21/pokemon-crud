package com.crud.pokemon.model;

import com.crud.pokemon.model.dto.pokemon.PokemonRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "pokemons")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pokemon implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private String abilities;

    private String type;
    private String weakness;

    private String height;
    private String weight;

    public void returner(PokemonRequestDTO request) {
        this.setName(request.getName());
        this.setCategory(request.getCategory());
        this.setAbilities(request.getAbilities());
        this.setType(request.getType());
        this.setWeakness(request.getWeakness());
        this.setHeight(request.getHeight());
        this.setWeight(request.getWeight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(id, pokemon.id) && Objects.equals(name, pokemon.name) && Objects.equals(abilities, pokemon.abilities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, abilities);
    }
}
