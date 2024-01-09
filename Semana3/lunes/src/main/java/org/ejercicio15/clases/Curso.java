package org.ejercicio15.clases;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ejercicio15.interfaces.Estudiante;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class Curso {
    private String codigo;
    private String nombre;
    private ArrayList<Estudiante> estudiantes;

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        estudiantes = new ArrayList<>();
    }

    public void printCurso() throws Exception{
        ObjectMapper objMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String json = objMapper.writeValueAsString(this);
        System.out.println(json);
    }
}
