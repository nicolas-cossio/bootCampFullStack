create table if not exists profesores(
                                         profesor_id serial primary key,
                                         nombre varchar(30) not null ,
                                         apellido varchar(30) not null,
                                         email varchar(70) not null unique );

select * from profesores;

create table if not exists cursos(
                                     curso_id serial primary key,
                                     nombre varchar(20) not null,
                                     profesor_id_fk integer,
                                     foreign key(profesor_id_fk)
                                         references profesores(profesor_id)
                                         on delete set null
);

select * from profesores join cursos c on profesores.profesor_id = c.profesor_id_fk;

insert into profesores(nombre, apellido, email)
values('Jorge', 'Huamani', 'jhuamania@gmail.com');

insert into cursos(nombre, profesor_id_fk)
values ('Algoritmos', 2),
       ('Fisica', 1),
       ('Software', 4);

-- SQL2
create table usuarios(
                         usuario_id serial primary key ,
                         nombre varchar not null
);

create table productos(
                          producto_id serial primary key,
                          nombre varchar not null,
                          usuario_id_fk integer,
                          foreign key(usuario_id_fk)
                              references usuarios(usuario_id)
                              on delete set null
);


