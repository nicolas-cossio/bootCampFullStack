package org.excepciones;

import java.io.FileReader;

public class Main {
    // Para trabajar con algo dentro de static debe ser static.
    public static void main(String[] args) {
        metodo1();
        metodo2("/file.txt");
    }

    public static void metodo1() {
        int[] numeros = {1,2,3,4,5};
        System.out.println(numeros[0]);
        try {
            System.out.println(numeros[5]);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Despues del error.");
    }

    public static void metodo2(String path) {
        try {
            FileReader fr = new FileReader(path);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
