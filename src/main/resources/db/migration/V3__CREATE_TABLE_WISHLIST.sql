CREATE TABLE IF NOT EXISTS public.wishlist (
    id SERIAL PRIMARY KEY,
    pokemon_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT fk_pokemon_id FOREIGN KEY (pokemon_id)
        REFERENCES pokemons (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT fk_user_id FOREIGN KEY (user_id)
        REFERENCES users (id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
