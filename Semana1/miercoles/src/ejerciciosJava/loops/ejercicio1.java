package ejerciciosJava.loops;

import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
        Scanner objInput = new Scanner(System.in);
        System.out.println("Ingrese un numero cualquiera:");
        int input = objInput.nextInt();

        for (int i = 0; i < input; i++) {
            System.out.println("Hola Mundo");
        }
    }
}
