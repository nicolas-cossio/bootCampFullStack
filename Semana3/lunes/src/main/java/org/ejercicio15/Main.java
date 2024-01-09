package org.ejercicio15;

import org.ejercicio15.clases.App;
import org.ejercicio15.clases.Curso;
import org.ejercicio15.clases.EstudianteProfesor;
import org.ejercicio15.interfaces.Usuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        App app = new App();

        app.addUsuario(new EstudianteProfesor("Jose", 1));
        app.addUsuario(new EstudianteProfesor("Maria", 2));
        app.addUsuario(new EstudianteProfesor("Javier", 3));
        app.addUsuario(new EstudianteProfesor("Jesus", 4));

        app.addCurso(new Curso("C123", "Programación"));
        app.addCurso(new Curso("M342", "Matematicas 1"));
        app.addCurso(new Curso("F435", "Fisica 1"));

        Scanner objInput = new Scanner(System.in);
        while(true) {
            System.out.println("1. Asignar profesor al curso");
            System.out.println("4. Mostrar cursos");

            int option = objInput.nextInt();
            if (option == 1) {
                System.out.println("Ingrese el id del profesor");
                int idProf = objInput.nextInt();
                System.out.println("Ingrese el id del curso");
                String idCurso = objInput.next();
                app.asignarProfesor(idProf, idCurso);
            }
            else if (option == 4) {
                System.out.println("Ingrese el id del curso");
                String idCurso = objInput.next();
                app.printCurso(idCurso);
            }
        }


    }
}
