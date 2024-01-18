create table if not exists usuarios(
    usuario_id serial primary key,
    username varchar(20) not null unique,
    password varchar not null,
    email varchar not null unique,
    direccion varchar not null
);

create table if not exists posts(
    post_id serial primary key,
    usuario_id_fk integer references usuarios(usuario_id) on delete set null,
    titulo varchar(30) not null,
    contenido text,
    fecha_creacion date default current_date
);

create table if not exists comentarios(
    comentario_id serial primary key,
    usuario_id_fk integer references usuarios(usuario_id) on delete set null,
    post_id_fk integer references posts(post_id) on delete cascade,
    contenido text,
    num_reacciones integer
);

create table if not exists categorias(
    categoria_id serial primary key,
    nombre varchar not null,
    descripcion text
);

create table if not exists post_categoria(
    post_id_fk integer references posts(post_id),
    categoria_id_fk integer references categorias(categoria_id)
);

SELECT * from usuarios;

-- https://www.mockaroo.com/

