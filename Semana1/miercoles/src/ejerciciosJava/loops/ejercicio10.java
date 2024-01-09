package ejerciciosJava.loops;

import java.util.Scanner;

public class ejercicio10 {
    public static void main(String[] args) {
        Scanner objInput = new Scanner(System.in);
        int n = objInput.nextInt();
        int t = objInput.nextInt();
        int libros[] = new int[n];
        for (int i = 0; i < n; i++) {
            int time = objInput.nextInt();
            libros[i] = time;
        }
//        Obtenemos la cantidad maxima de libros que se pueden leer
        int maxLibros = 0;
        for (int i = 0; i < n; i++) {
            int suma = 0;
            int cantLibros = 0;
            for (int j = i; j < n; j++) {
                suma+=libros[j];
                if (suma > t){
                    break;
                }
                cantLibros++;
            }
            if (cantLibros >= maxLibros){
                maxLibros = cantLibros;
            }
        }
        System.out.println(maxLibros);
    }
}
