create table if not exists autores(
    autor_id serial primary key,
    nombre varchar not null
);

create table if not exists direcciones(
    direccion_id serial primary key,
    direccion varchar not null unique,
    autor_id_fk integer references autores(autor_id)
                        on delete cascade);

