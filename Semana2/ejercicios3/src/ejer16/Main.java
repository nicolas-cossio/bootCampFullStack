package ejercicios3.ejer16;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Yaris", 2006, "AAA-111",
            6, "Regular");
        Motorcycle moto1 = new Motorcycle("Yamaha", "A", 2024,
                "AVC-954", 1000, false);
        Truck truck1 = new Truck("Volvo", "X10", 2014, "XDS-414",
                500, 6);
        VehicleRegistry system = new VehicleRegistry();
        system.registerVehicle(car1);
        system.registerVehicle(moto1);
        system.registerVehicle(truck1);

        system.showAllVehicles();

        System.out.println();
        Vehicle v = system.findVehicle("AAA-111");
        if (v == null){
            System.out.println("Vehiculo no encontrado.");
        }
        else {
            v.showDetails();
        }
    }
}
