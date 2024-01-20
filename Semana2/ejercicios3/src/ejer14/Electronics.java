package ejercicios3.ejer14;

public class Electronics extends Product{
    private String brand;
    private String model;

    public Electronics(int productId, String productName, float price, String brand, String model) {
        super(productId, productName, price);
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void showProduct() {
        System.out.println("Product ID: "+productId+" - Product Name: "+productName+" - Price: "+
                price+" - Brand: "+brand+" - Model: "+model);
    }

}
