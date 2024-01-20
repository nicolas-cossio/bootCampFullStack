package ejercicios3.ejer17;

import java.util.ArrayList;

public class Gerente extends Empleado {
    private ArrayList<Empleado> empleadosCargo = new ArrayList<>();

    public Gerente(String nombre, int id, String departamento) {
        super(nombre, id, departamento);
    }

    public void addEmpleado(Empleado emp) {
        empleadosCargo.add(emp);
    }

    @Override
    public void mostrar_info() {
        System.out.println("Nombre: "+getNombre()+" ID: "+getId()+" Departamento:"+getDepartamento());
        System.out.print("Empleados a cargo: ");
        for (int i = 0; i < empleadosCargo.size(); i++) {
            if (i+1 == empleadosCargo.size()) {
                System.out.print(empleadosCargo.get(i).getNombre());
            }
            else {
                System.out.print(empleadosCargo.get(i).getNombre()+", ");
            }
        }
        System.out.println();
    }

    @Override
    public void calcular_salario() {
        System.out.println("El salario del gerente es de 7500 soles");
    }
}
