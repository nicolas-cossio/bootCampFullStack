package tarea;

import java.util.Scanner;

public class ejercicio4 {
    public static void main(String[] args) {
//        Ejercicio 4: Factorial de un número
//        Calcula el factorial de un número ingresado por el usuario. El factorial de
//        un número n (representado como es el producto de todos los enteros positivos
//        menores o iguales a n.

//        Debe ingresar un numero como input para obtener el factorial de ese numero.
        Scanner objInput = new Scanner(System.in);
        int input = objInput.nextInt();
        int factorial = 1;
        for (int i = input; i > 0; i--) {
            factorial *= i;
        }
        System.out.println(factorial);
    }
}
