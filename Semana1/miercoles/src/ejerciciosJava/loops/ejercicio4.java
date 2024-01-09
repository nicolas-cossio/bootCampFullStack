package ejerciciosJava.loops;

import java.util.Scanner;

public class ejercicio4 {
    public static void main(String[] args) {
        Scanner objInput = new Scanner(System.in);
        System.out.println("Ingrese un numero cualquiera:");
        int input = objInput.nextInt();

        int suma = 0;
        for (int i = 0; i <= input; i++) {
            suma += i;
        }
        System.out.println(suma);
    }
}
