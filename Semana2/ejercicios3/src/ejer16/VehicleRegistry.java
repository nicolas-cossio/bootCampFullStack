package ejercicios3.ejer16;

import java.util.ArrayList;

public class VehicleRegistry {
    private ArrayList<Vehicle> registeredVehicles = new ArrayList<>();

    public void registerVehicle(Vehicle vehicle) {
        registeredVehicles.add(vehicle);
    }

    public void showAllVehicles() {
        for (Vehicle v : registeredVehicles) {
            v.showDetails();
        }
    }

    public Vehicle findVehicle(String number) {
        for (Vehicle v : registeredVehicles) {
            if (v.getRegistrationNumber().equals(number)) {
                return v;
            }
        }
        return null;
    }
}
