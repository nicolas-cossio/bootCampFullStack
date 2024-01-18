create table if not exists autores(
    autor_id serial primary key,
    nombre varchar not null unique
);