package ejercicios3.ejer17;

public class Diseniador extends Empleado{
    private String tipoDisenio;

    public Diseniador(String nombre, int id, String departamento, String tipoDisenio) {
        super(nombre, id, departamento);
        this.tipoDisenio = tipoDisenio;
    }

    public String getTipoDisenio() {
        return tipoDisenio;
    }

    public void setTipoDisenio(String tipoDisenio) {
        this.tipoDisenio = tipoDisenio;
    }

    @Override
    public void mostrar_info() {
        System.out.println("Nombre: "+getNombre()+" ID: "+getId()+" Departamento:"+getDepartamento()
                +" Tipo de diseño: "+tipoDisenio);
    }

    @Override
    public void calcular_salario() {
        System.out.println("El salario del diseñador es de 3000 soles");
    }
}
