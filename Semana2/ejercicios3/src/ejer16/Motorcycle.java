package ejercicios3.ejer16;

public class Motorcycle extends Vehicle {
    private int engineSize;
    private boolean hasSidecar;

    public Motorcycle(String make, String model, int year, String registrationNumber, int engineSize,
                      boolean hasSidecar) {
        super(make, model, year, registrationNumber);
        this.engineSize = engineSize;
        this.hasSidecar = hasSidecar;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }

    public void showDetails() {
        System.out.println("Make: "+getMake()+" - Model: "+getModel()+" - Year: "+getYear()+
                " - Registration Number: "+getRegistrationNumber()+" - Engine Size: "+engineSize
                +" - Has side car? "+hasSidecar);
    }
}
