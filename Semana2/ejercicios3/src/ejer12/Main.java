package ejercicios3.ejer12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Meditations", 1, false, "Marco Aurelius");
        Book book2 = new Book("Atomic Habits", 2, false, "James Clear");
        DVD dvd1 = new DVD("Fast & Furious 1", 3, false, "A", "2:00:13");
        DVD dvd2 = new DVD("Fast & Furious 2", 4, false, "A", "3:19:13");
        DVD dvd3 = new DVD("Fast & Furious 3", 5, false, "A", "3:14:20");

        Library library = new Library();
        library.addItem(book1);
        library.addItem(book2);
        library.addItem(dvd1);
        library.addItem(dvd2);
        library.addItem(dvd3);

        LibraryUser user1 = new LibraryUser("Jose", 1);
        LibraryUser user2 = new LibraryUser("Javier", 2);
        LibraryUser user3 = new LibraryUser("Jesus", 3);

        //        "INTERFAZ"
        Scanner objInput = new Scanner(System.in);
        System.out.println("Welcome to Library System:");
        while (true) {
//            String name = objInput.nextLine();
            System.out.println("\nWhat would you like to do? Pick some of the options below:");
            System.out.println("1. Rent an item");
            System.out.println("2. Return an item");
            System.out.println("3. Show all items");
            System.out.println("4. Show all users");
            System.out.println("Press 0 to exit.");
            System.out.print("Option: ");
            int option = objInput.nextInt();
            if (option == 0) {
                System.out.println("Good Bye..");
                break;
            }
            if (option == 1) {
                library.showAllItems();

            }
            if (option == 2) {

            }
            if (option == 3) {

            }
            if (option == 4) {

            }
            if (option > 4) {
                System.out.println("Pick a valid option.");
            }
        }

        library.showAllItems();
    }
}
