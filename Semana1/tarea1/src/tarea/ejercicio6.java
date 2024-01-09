package tarea;

public class ejercicio6 {
    public static void main(String[] args) {
//        Ejercicio 6: Encuentra y muestra todos los cuadrados perfectos
//        hasta 100.
        int mult = 0, i = 1;
        while(mult < 100){
            mult = i*i;
            System.out.println(mult);
            i += 1;
        }
    }
}
