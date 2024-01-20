package ejercicios3.ejer16;

public class Car extends Vehicle {
    private int seatingCapacity;
    private String fuelType;

    public Car(String make, String model, int year, String registrationNumber, int seatingCapacity,
               String fuelType) {
        super(make, model, year, registrationNumber);
        this.seatingCapacity = seatingCapacity;
        this.fuelType = fuelType;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void showDetails() {
        System.out.println("Make: "+getMake()+" - Model: "+getModel()+" - Year: "+getYear()+
                " - Registration Number: "+getRegistrationNumber()+" - Seating Capacity: "+seatingCapacity
                +" - Fuel Type: "+fuelType);
    }
}
