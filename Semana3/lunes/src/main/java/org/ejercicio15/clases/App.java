package org.ejercicio15.clases;

import org.ejercicio15.interfaces.Usuario;

import java.util.ArrayList;

public class App {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Curso> cursos;

    public App() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Curso> cursos = new ArrayList<>();
    }

    public void addCurso(Curso curso) {
        cursos.add(curso);
    }

    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
}
