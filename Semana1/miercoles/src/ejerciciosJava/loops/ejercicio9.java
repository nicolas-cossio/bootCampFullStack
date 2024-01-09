package ejerciciosJava.loops;

import java.util.Scanner;

public class ejercicio9 {
    public static void main(String[] args) {
        Scanner objInput = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de elementos que tendrá el arreglo:");
        int n = objInput.nextInt();

        int arr[] = new int[n];
        System.out.println("Ingrese los valores del arreglo:");
        for (int i = 0; i < n; i++) {
            arr[i] = objInput.nextInt();
        }

        System.out.println("Ingrese el numero a buscar:");
        int m = objInput.nextInt();

        boolean existe = false;
        for (int i = 0; i < n; i++) {
            if (arr[i] == m){
                existe = true;
                break;
            }
        }
        System.out.println(existe);
    }
}
