package ejercicios3.ejer17;

import java.util.ArrayList;

public class Desarrollador extends Empleado {
    private ArrayList<String> lenguajes;

    public Desarrollador(String nombre, int id, String departamento) {
        super(nombre, id, departamento);
        lenguajes = new ArrayList<>();
    }

    public void addLenguaje(String lenguaje) {
        lenguajes.add(lenguaje);
    }

    @Override
    public void calcular_salario() {
        System.out.println("El salario del desarrollador es de 3500 soles");
    }

    @Override
    public void mostrar_info() {
        System.out.println("Nombre: "+getNombre()+" ID: "+getId()+" Departamento:"+getDepartamento());
        System.out.print("Lenguajes de Programación: ");
        System.out.println(lenguajes);
    }
}
