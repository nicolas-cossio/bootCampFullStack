package org.ejercicio15.clases;

import lombok.Getter;
import lombok.Setter;
import org.ejercicio15.interfaces.Estudiante;

import java.util.ArrayList;

@Getter
@Setter
public class SoloEstudiante extends Persona implements Estudiante {
    private ArrayList<Curso> cursosEstd = new ArrayList<>();

    @Override
    public void matricularCurso() {

    }

    @Override
    public void entregarTarea() {

    }
}
