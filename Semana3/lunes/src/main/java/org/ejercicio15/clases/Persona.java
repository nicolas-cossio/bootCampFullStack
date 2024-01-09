package org.ejercicio15.clases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.ejercicio15.interfaces.Usuario;

@Getter
@Setter
@AllArgsConstructor
//  Es abstracta pq es una clase general.
public abstract class Persona implements Usuario {
    protected String nombre;
    protected int id;
}
