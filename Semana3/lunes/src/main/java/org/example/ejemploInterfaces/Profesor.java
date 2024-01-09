package org.example.ejemploInterfaces;

public class Profesor implements Usuario{
    @Override
    public void login() {
        System.out.println("Profesor iniciando sesión...");
    }

    @Override
    public void logout() {
        System.out.println("Profesor cerrando sesión...");
    }
}
