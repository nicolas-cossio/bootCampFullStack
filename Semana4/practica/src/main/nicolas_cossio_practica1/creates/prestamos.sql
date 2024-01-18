create table if not exists prestamos(
  prestamo_id serial primary key,
  fecha_prestamo date default current_date,
  fecha_devolucion_esperada date,
    ISBN_fk varchar references libros(isbn) on delete cascade,
    lector_id_fk int references lectores(lector_id) on delete set null
);