package ejercicios3.ejer12;


import java.util.ArrayList;

public class Library {
    private ArrayList<LibraryItem> libraryItems = new ArrayList<>();
    private ArrayList<LibraryUser> users  = new ArrayList<>();

    public void addItem(LibraryItem item) {
        libraryItems.add(item);
    }

    public void showAllItems() {
        System.out.println("\nLIBRARY COLLECTION ITEMS:");
        for (LibraryItem i : libraryItems){
            i.showDetails();
        }
    }

    public void addUser(LibraryUser user) { users.add(user); }

    public void removeUser(int idUser) {
        LibraryUser user = new LibraryUser();
        boolean userFound = false;
        for (LibraryUser u : users) {
            if (u.getUserID()==idUser) {
                user = u;
                userFound = true;
                break;
            }
        }
        if (!userFound) {
            System.out.println("Id not found.");
            return;
        }
        users.remove(user);
    }

    public void loanItem(int idItem, int idUser) {
//        Buscamos el usuario.
        LibraryUser user = new LibraryUser();
        boolean userFound = false;
        for (LibraryUser u : users) {
            if (u.getUserID()==idUser) {
                user = u;
                userFound = true;
                break;
            }
        }
//        Buscamos el item.
        LibraryItem item = new LibraryItem();
        boolean itemFound = false;
        for (LibraryItem i : libraryItems) {
            if (i.getItemID()==idItem) {
                item = i;
                itemFound = true;
                break;
            }
        }
//        Pueden ocurrir 3 casos
        if (!userFound) {
            System.out.println("User not found.");
            return;
        }
        if (!itemFound) {
            System.out.println("Item not found.");
            return;
        }
//      Si el metodo no termina es porque los dos son true entonces
        if (item.isLoaned()) {           // Si está prestado
            System.out.println("The user: "+user.getUserName()+ " can't loan the item because " +
                    "it's not available");
        }
        else {                          // Si NO está prestado
            System.out.println("Item loaned.");
            item.setLoaned(true);
            user.getLoanedItems().add(item);
        }
    }

    public void returnItem(int idItem, int idUser) {
        //        Buscamos el usuario.
        LibraryUser user = new LibraryUser();
        boolean userFound = false;
        for (LibraryUser u : users) {
            if (u.getUserID()==idUser) {
                user = u;
                userFound = true;
                break;
            }
        }
//        Buscamos el item.
        LibraryItem item = new LibraryItem();
        boolean itemFound = false;
        for (LibraryItem i : libraryItems) {
            if (i.getItemID()==idItem) {
                item = i;
                itemFound = true;
                break;
            }
        }
//        Pueden ocurrir 3 casos
        if (!userFound) {
            System.out.println("User not found.");
            return;
        }
        if (!itemFound) {
            System.out.println("Item not found.");
            return;
        }
//        Validar que el item haya sido prestado por el usuario
        boolean libroPrestado = false;
        for (LibraryItem i : user.getLoanedItems()) {
            if (i.getItemID()==idItem) {
                libroPrestado = true;
                break;
            }
        }
        // Si el libro no fue prestado por el usuario entonces termina.
        if (!libroPrestado) {
            System.out.println("The user didn't loan the book.");
        }
        else {
            System.out.println("Item returned correctly.");
            item.setLoaned(false);
            user.getLoanedItems().remove(item);
        }

    }
}
