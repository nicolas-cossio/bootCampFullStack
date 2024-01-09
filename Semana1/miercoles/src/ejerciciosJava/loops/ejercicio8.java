package ejerciciosJava.loops;

import java.util.Scanner;

public class ejercicio8 {
    public static void main(String[] args) {
        Scanner objInput = new Scanner(System.in);
        System.out.println("Ingrese un valor de n:");
        int n = objInput.nextInt();

        while (n != 1){
            // Si es par
            if (n % 2 == 0){
                n = n/2;
            }
            // Caso contrario
            else {
                n = 3 * n + 1;
            }
            System.out.println("Valor de n: "+n);
        }
    }
}
