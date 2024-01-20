package ejercicios3.ejer13;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Movie mov1 = new Movie("Fast & Furious 1", 1, true, "A",
                "2:00:13", 15, "Action");
        Movie mov2 = new Movie("Fast & Furious 3", 2, true, "A",
                "2:34:13", 15, "Action");
        Movie mov3 = new Movie("Fast & Furious 5", 3, true, "A",
                "2:59:13", 15, "Action");
        Movie mov4 = new Movie("Fast & Furious 7", 4, true, "A",
                "3:19:13", 18, "Action");

        MovieRentalSystem system = new MovieRentalSystem();
        system.addItem(mov1);
        system.addItem(mov2);
        system.addItem(mov3);
        system.addItem(mov4);

//        "INTERFAZ"
        Scanner objInput = new Scanner(System.in);
        System.out.println("Welcome to MovieRental System:");
        System.out.print("Write your name to continue: ");
        String name = objInput.nextLine();
        Customer user = new Customer(name, 1);
        system.registerCustomer(user);

        while (true) {
            System.out.println("\nWhat would you like to do? Pick some of the options below:");
            System.out.println("1. Show all movies");
            System.out.println("2. Show your rented movies");
            System.out.println("Press 0 to exit.");
            System.out.print("Option: ");

            int option = objInput.nextInt();
            if (option == 0) {
                System.out.println("Good Bye..");
                break;
            }
            if (option == 1){
                System.out.println("What movie would you like to rent?");
                system.showAllItems();
                System.out.println("Press 0 to exit..");
                int movie = objInput.nextInt();
                system.rentMovieToCustomer(movie, user);
            }
            if (option == 2){
                user.showCustomerDetails();
                if (!user.getRentedMovies().isEmpty()) {
                    System.out.println("What movie you like to return?");
                    System.out.println("Press 0 to exit..");
                    int movie = objInput.nextInt();
                    system.returnMovie(movie, user);
                }
                else {
                    System.out.println("You haven't rent a movie");
                }
            }
            if (option > 2) System.out.println("Pick an available option");
        }
    }
}
