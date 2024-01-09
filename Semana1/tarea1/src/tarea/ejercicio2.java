package tarea;

public class ejercicio2 {
    public static void main(String[] args) {
//        Ejercicio 2: Suma de números pares
//        Suma todos los números impares del 1 al 100.
        int result = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0){
                result += i;
            }
        }
        System.out.println(result);
    }
}
