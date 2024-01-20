package ejercicios3.ejer14;

public class Clothing extends Product {
    private String size;
    private String material;

    public Clothing(int productId, String productName, float price, String size, String material) {
        super(productId, productName, price);
        this.size = size;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public void showProduct() {
        System.out.println("Product ID: "+productId+" - Product Name: "+productName+" - Price: "+
                price+" - Size: "+size+" - Material: "+material);
    }

}
