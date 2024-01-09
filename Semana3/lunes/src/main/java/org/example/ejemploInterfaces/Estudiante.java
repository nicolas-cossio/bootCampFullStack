package org.example.ejemploInterfaces;

public class Estudiante implements Usuario{

    @Override
    public void login() {
        System.out.println("Estudiante iniciando sesión...");
    }

    @Override
    public void logout() {
        System.out.println("Estudiante cerrando sesión...");
    }
}
