package org.ejercicio15.clases;

import lombok.Getter;
import lombok.Setter;
import org.ejercicio15.interfaces.Usuario;

@Getter
@Setter
public class Persona implements Usuario {
    protected String nombre;
    protected int id;

    @Override
    public void iniciarSesion() {

    }

    @Override
    public void cerrarSesion() {

    }
}
