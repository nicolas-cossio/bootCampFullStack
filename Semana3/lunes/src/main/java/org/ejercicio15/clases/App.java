package org.ejercicio15.clases;

import org.ejercicio15.interfaces.Profesor;
import org.ejercicio15.interfaces.Usuario;

import java.util.ArrayList;

public class App {
    private ArrayList<SoloEstudiante> estudiantes;
    private ArrayList<EstudianteProfesor> estudianteProfesors;
    private ArrayList<Curso> cursos;

    public App() {
        ArrayList<SoloEstudiante> estudiantes = new ArrayList<>();
        ArrayList<EstudianteProfesor> estudianteProfesors = new ArrayList<>();
        ArrayList<Curso> cursos = new ArrayList<>();
    }

    public void addCurso(Curso curso) {
        cursos.add(curso);
    }

    public void addUsuario(Usuario usuario) {
        if(usuario.getClass().getSimpleName().equals("SoloEstudiante")) {
            estudiantes.add((SoloEstudiante) usuario);
        }
        else {
            estudianteProfesors.add((EstudianteProfesor) usuario);
        }
    }

    public void asignarProfesor(int idProf, String codCurso) {
        // Buscamos el curso
        boolean encontrado = false;
        Curso curso = findCursoByCod(codCurso, encontrado);
        if (!encontrado) {
            System.out.println("No se encontró el curso");
            return;
        }
        //  Si encuentra el curso
        for (EstudianteProfesor ep : estudianteProfesors) {
            if (ep.getId() == idProf) {
                //  Asignamos el curso al profe
                ep.addImpartidos(curso);
            }
        }
    }

    public void printCurso(String codigo) throws Exception {
        boolean encontrado = false;
        Curso c = findCursoByCod(codigo, encontrado);
        if (!encontrado) {
            System.out.println("No se encontró el curso");
            return;
        }
        c.printCurso();
    }

    Curso findCursoByCod(String cod, boolean encontrado) {
        Curso curso = new Curso();
        for (Curso c : cursos) {
            if (c.getCodigo().equals(cod)) {
                curso = c;
                encontrado = true;
                break;
            }
        }
        return curso;
    }
 }
