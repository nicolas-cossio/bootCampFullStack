package tarea;

import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
//        Ejercicio 5: Suma de dígitos
//        Descripción: Suma todos los dígitos de un número ingresado por el
//        usuario. No usar la conversión a String para resolver el problema.

//        Debe ingresar un numero de más de 2 digitos
        Scanner objInput = new Scanner(System.in);
        int input = objInput.nextInt();
        boolean iterar = true;
        int suma = 0;
        int digito;
        while(iterar){
            if(input / 10 == 0){
                iterar = false;
            }
            digito = input % 10;
            input /= 10;

            suma += digito;
        }
        System.out.println(suma);
    }
}
