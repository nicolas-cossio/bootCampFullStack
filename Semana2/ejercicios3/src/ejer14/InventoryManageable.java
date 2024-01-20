package ejercicios3.ejer14;

public interface InventoryManageable {
    void addItem(Product product);
    void deleteItem(Product product);
    void listItems();
    Product findItemById(int id);
}
