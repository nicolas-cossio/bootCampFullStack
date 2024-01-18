create table if not exists lectores(
  lector_id serial primary key,
  nombre varchar not null unique
);