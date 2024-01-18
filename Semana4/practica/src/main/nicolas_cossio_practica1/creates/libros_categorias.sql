create table if not exists libros_categorias(
    ISBN varchar references libros(isbn) on delete cascade,
    categoria_id int references categorias(categoria_id) on delete cascade,
    primary key (ISBN, categoria_id)
);