package ejercicios3.ejer12;

import java.util.ArrayList;

public class LibraryUser {
    private String userName;
    private int userID;
    private ArrayList<LibraryItem> loanedItems = new ArrayList<>();

    public LibraryUser() {
    }

    public LibraryUser(String userName, int userID) {
        this.userName = userName;
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public ArrayList<LibraryItem> getLoanedItems() {
        return loanedItems;
    }

    public void showUserDetails() {
        System.out.println("userName: "+userName+" userID: "+userID);
        System.out.println("Loaned Items:");
        if (loanedItems.size() > 1) {
            for (LibraryItem li : loanedItems){
                li.showDetails();
            }
        }
        else {
            System.out.println("No loaned items yet.");
        }
    }
}
