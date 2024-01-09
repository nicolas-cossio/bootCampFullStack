package org.ejercicio15.clases;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.ejercicio15.interfaces.Estudiante;
import org.ejercicio15.interfaces.Profesor;

import java.util.ArrayList;


public class EstudianteProfesor extends Persona implements Estudiante, Profesor {
    private ArrayList<Curso> cursosInscritos = new ArrayList<>();
    private ArrayList<Curso> cursosImpartidos = new ArrayList<>();

    public EstudianteProfesor(String nombre, int id) {
        super(nombre, id);
    }

    // Estudiante
    @Override
    public void matricularCurso() {

    }

    @Override
    public void entregarTarea() {

    }

    // Profesor
    @Override
    public void calificarExamen() {

    }

    @Override
    public void asignarTarea() {

    }

    // Usuario
    @Override
    public void iniciarSesion() {

    }

    @Override
    public void cerrarSesion() {

    }

    @Override
    public void printInfo() throws Exception{
        System.out.println("EstudianteProfesor");
        ObjectMapper objMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String json = objMapper.writeValueAsString(this);
        System.out.println(json);
    }

    public void addImpartidos(Curso c) {
        cursosImpartidos.add(c);
    }
}
