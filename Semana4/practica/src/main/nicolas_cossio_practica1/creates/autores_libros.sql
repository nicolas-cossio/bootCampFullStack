create table if not exists autores_libros(
    autor_id int references autores(autor_id) on delete cascade,
    ISBN varchar references libros(isbn) on delete cascade,
    primary key (autor_id, ISBN)
);