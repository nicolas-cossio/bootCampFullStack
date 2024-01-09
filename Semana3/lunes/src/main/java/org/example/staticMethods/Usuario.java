package org.example.staticMethods;

public class Usuario {
    String nombre;
    int edad;
    public static int contador = 0;

    public Usuario(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        contador++;
    }

    public static void sumarUno() {
        contador++;
    }

    // Inicializar atributos estáticos. Solo se ejecuta la primera que se llama a la clase.
    static {
        System.out.println("Hola desde STATIC.");
    }
}
