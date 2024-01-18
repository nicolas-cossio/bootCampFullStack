create table if not exists categorias(
  categoria_id serial primary key,
  nombre varchar not null unique
);