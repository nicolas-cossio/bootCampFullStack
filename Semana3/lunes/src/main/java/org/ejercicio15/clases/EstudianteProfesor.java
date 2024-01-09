package org.ejercicio15.clases;

import org.ejercicio15.interfaces.Estudiante;
import org.ejercicio15.interfaces.Profesor;

import java.util.ArrayList;

public class EstudianteProfesor extends Persona implements Estudiante, Profesor {
    private ArrayList<Curso> cursosInscritos = new ArrayList<>();
    private ArrayList<Curso> cursosImpartidos = new ArrayList<>();

    @Override
    public void matricularCurso() {

    }

    @Override
    public void entregarTarea() {

    }

    @Override
    public void calificarExamen() {

    }

    @Override
    public void asignarTarea() {

    }
}
