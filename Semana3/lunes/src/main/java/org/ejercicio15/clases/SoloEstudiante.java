package org.ejercicio15.clases;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Getter;
import lombok.Setter;
import org.ejercicio15.interfaces.Estudiante;

import java.util.ArrayList;

@Getter
@Setter
public class SoloEstudiante extends Persona implements Estudiante {
    private ArrayList<Curso> cursosEstd = new ArrayList<>();

    public SoloEstudiante(String nombre, int id) {
        super(nombre, id);
    }

    // Estudiante
    @Override
    public void matricularCurso() {

    }

    @Override
    public void entregarTarea() {

    }

    // Usuario
    @Override
    public void iniciarSesion() {

    }

    @Override
    public void cerrarSesion() {

    }

    @Override
    public void printInfo() throws Exception {
        System.out.println("SoloEstudiante");
        ObjectMapper objMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String json = objMapper.writeValueAsString(this);
        System.out.println(json);
    }
}
