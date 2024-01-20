package ejercicios3.ejer13;

public class RentalItem {
    private String itemName;
    private int itemID;
    private boolean available;

    public RentalItem(String itemName, int itemID, boolean available) {
        this.itemName = itemName;
        this.itemID = itemID;
        this.available = available;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void showDetails() {
        if (available){
            System.out.println("itemName: "+itemName+" ID: "+itemID+" Status: Available");
        }
        else{
            System.out.println("itemName: "+itemName+" ID: "+itemID+" Status: NOT Available");
        }
    }
}
