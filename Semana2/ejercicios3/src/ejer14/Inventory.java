package ejercicios3.ejer14;

import java.util.ArrayList;

public class Inventory implements InventoryManageable{

    ArrayList<Product> products = new ArrayList<>();

    @Override
    public void addItem(Product product) {
        products.add(product);
    }

    @Override
    public void deleteItem(Product product) {
        products.remove(product);
    }

    @Override
    public void listItems() {
        for (Product p : products) {
            p.showProduct();
        }
    }

    @Override
    public Product findItemById(int id) {
        for (Product p: products) {
            if (p.getProductId() == id) {
                return p;
            }
        }
        return null;
    }
}
