package ejercicios3.ejer13;

import java.util.ArrayList;

public class Customer {
    private String customerName;
    private int customerID;
    private ArrayList<RentalItem> rentedMovies = new ArrayList<>();

    public Customer(String customerName, int customerID) {
        this.customerName = customerName;
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public ArrayList<RentalItem> getRentedMovies() {
        return rentedMovies;
    }

    public void addMovie(RentalItem item) {
        rentedMovies.add(item);
    }

    public void showCustomerDetails() {
        System.out.println("userName: "+customerName+" userID: "+customerID);
        if (!rentedMovies.isEmpty()) {
            System.out.println("Rented Movies:");
            for (RentalItem li : rentedMovies){
                li.showDetails();
            }
        }

    }
}
