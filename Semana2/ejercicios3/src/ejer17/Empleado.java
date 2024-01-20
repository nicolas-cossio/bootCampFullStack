package ejercicios3.ejer17;

public class Empleado {
    private String nombre;
    private int id;
    private String departamento;

    public Empleado(String nombre, int id, String departamento) {
        this.nombre = nombre;
        this.id = id;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void mostrar_info() {
        System.out.println("Nombre: "+nombre+" ID: "+id+" Departamento:"+departamento);
    }

    public void calcular_salario() {

    }
}
