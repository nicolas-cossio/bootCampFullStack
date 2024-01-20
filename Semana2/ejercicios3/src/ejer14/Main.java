package ejercicios3.ejer14;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Electronics celular1 = new Electronics(1, "Celular", 1000,
                "Xiaomi", "P20");
        Electronics celular2 = new Electronics(2, "Celular", 1000,
                "Samsung", "Flip 2");
        Clothing polo = new Clothing(3, "Polo", 150, "S", "Algodón");
        Clothing camisa = new Clothing(4, "Camisa", 350, "M", "Algodón");
        Clothing pantalon = new Clothing(5, "Pantalon", 200, "28", "Algodón");

        inventory.addItem(celular1);
        inventory.addItem(celular2);
        inventory.addItem(polo);
        inventory.addItem(camisa);
        inventory.addItem(pantalon);

        inventory.listItems();

        Product prod = inventory.findItemById(3);
        prod.setPrice(249.99f);

        Product prod2 = inventory.findItemById(2);
        inventory.deleteItem(prod2);

        System.out.println("\nAfter changes...");
        inventory.listItems();
    }
}
