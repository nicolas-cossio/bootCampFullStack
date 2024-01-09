package org.ejercicio15.clases;

import lombok.Getter;
import lombok.Setter;
import org.ejercicio15.interfaces.Estudiante;

import java.util.ArrayList;

@Getter
@Setter
public class Curso {
    private String codigo;
    private String nombre;
    private ArrayList<Estudiante> estudiantes;
}
