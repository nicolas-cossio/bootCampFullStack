package ejercicios3.ejer16;

public class Truck extends Vehicle {
    private int loadCapacity;
    private int numberOfAxles;

    public Truck(String make, String model, int year, String registrationNumber, int loadCapacity,
                 int numberOfAxles) {
        super(make, model, year, registrationNumber);
        this.loadCapacity = loadCapacity;
        this.numberOfAxles = numberOfAxles;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public int getNumberOfAxles() {
        return numberOfAxles;
    }

    public void setNumberOfAxles(int numberOfAxles) {
        this.numberOfAxles = numberOfAxles;
    }

    public void showDetails() {
        System.out.println("Make: "+getMake()+" - Model: "+getModel()+" - Year: "+getYear()+
                " - Registration Number: "+getRegistrationNumber()+" - Load Capacity: "+loadCapacity
                +" - Number of Axles: "+numberOfAxles);
    }
}
