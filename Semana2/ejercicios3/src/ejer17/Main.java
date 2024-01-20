package ejercicios3.ejer17;

public class Main {
    public static void main(String[] args) {
        Desarrollador dev1 = new Desarrollador("Juan", 1, "TI");
        Gerente gerente = new Gerente("Nicolas", 2, "Directorio");
        Diseniador dis1 = new Diseniador("Maria", 3, "Marketing",
                "Publicitario");

        Empresa emp = new Empresa();

        emp.añadir_empleado(dev1);
        emp.añadir_empleado(gerente);
        emp.añadir_empleado(dis1);

        dev1.addLenguaje("Java");
        dev1.addLenguaje("Javascript");
        dev1.addLenguaje("PHP");

        gerente.addEmpleado(dev1);
        gerente.addEmpleado(dis1);

        emp.mostrar_empleados();
    }
}
