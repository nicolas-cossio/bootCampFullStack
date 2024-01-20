package ejercicios3.ejer12;

public class LibraryItem {
    private String title;
    private int itemID;
    private Boolean isLoaned;

    public LibraryItem() {
    }

    public LibraryItem(String title, int itemID, Boolean isLoaned) {
        this.title = title;
        this.itemID = itemID;
        this.isLoaned = isLoaned;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public Boolean isLoaned() {
        return isLoaned;
    }

    public void setLoaned(Boolean loaned) {
        isLoaned = loaned;
    }

    public void showDetails(){
        if (!isLoaned){
            System.out.println("Title: "+title+" ID: "+itemID+" Status: Available");
        }
        else{
            System.out.println("Title: "+title+" ID: "+itemID+" Status: NOT Available");
        }
    }
}
