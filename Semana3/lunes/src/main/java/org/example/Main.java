package org.example;

import org.example.staticMethods.Usuario;

public class Main {
    public static void main(String[] args) {
        Usuario user = new Usuario("N", 20);
        Usuario user2 = new Usuario("M", 20);

        System.out.println(Usuario.contador);
        System.out.println(user2.contador);
        System.out.println(user.contador);

        Usuario.sumarUno();
        System.out.println(Usuario.contador);

    }
}
