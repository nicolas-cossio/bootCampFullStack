package ejercicios3.ejer13;

import java.util.ArrayList;

public class MovieRentalSystem {
    private ArrayList<RentalItem> rentalItems;
    private ArrayList<Customer> customers;

    public MovieRentalSystem() {
        rentalItems = new ArrayList<>();
        customers = new ArrayList<>();
    }

    public void addItem(RentalItem item) {
        rentalItems.add(item);
    }

    public void registerCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentMovieToCustomer(int itemID, Customer customer) {
        for (RentalItem i : rentalItems) {
            if (i.getItemID() == itemID) {
                if (i.isAvailable()) {
                    System.out.println("Movie rented correctly");
                    i.setAvailable(false);
                    customer.addMovie(i);
                }
            }
        }
    }

    public void returnMovie(int itemID, Customer customer) {
        for (RentalItem i : rentalItems) {
            if (i.getItemID() == itemID) {
                if (customer.getRentedMovies().remove(i)) {
                    System.out.println("Movie returned correctly");
                    i.setAvailable(true);
                }
            }
        }
    }

    public void showAllItems() {
        for (RentalItem i : rentalItems) {
            if (i.isAvailable()) {
                i.showDetails();
            }
        }
    }

    public void showAllCustomers() {
        for (Customer c : customers) {
            c.showCustomerDetails();
        }
    }
}
