package ejerciciosJava.loops;

import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        Scanner objInput = new Scanner(System.in);
        System.out.println("Ingrese un numero cualquiera:");
        int input = objInput.nextInt();

        for (int i = 0; i < input; i+=2){
                System.out.println(i);
        }
    }
}
