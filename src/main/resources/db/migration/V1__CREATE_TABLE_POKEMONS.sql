CREATE TABLE IF NOT EXISTS pokemons (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    abilities VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    category VARCHAR(255),
    height VARCHAR(255),
    weight VARCHAR(255),
    weakness VARCHAR(255),
    active BOOLEAN NOT NULL
);