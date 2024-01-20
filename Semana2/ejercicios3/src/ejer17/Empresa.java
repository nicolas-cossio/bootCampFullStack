package ejercicios3.ejer17;

import java.util.ArrayList;

public class Empresa {
    private ArrayList<Empleado> empleados = new ArrayList<>();

    public void añadir_empleado(Empleado emp) {
        empleados.add(emp);
    }

    public void eliminar_empleado(int id) {
        for (Empleado e : empleados) {
            if(e.getId()==id) {
                empleados.remove(e);
            }
        }
    }

    public void mostrar_empleados() {
        for (Empleado e : empleados) {
            e.mostrar_info();
        }
    }
}
