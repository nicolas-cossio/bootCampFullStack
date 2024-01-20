package ejercicios3.ejer14;

abstract class Product implements Priceable{
    protected int productId;
    protected String productName;
    protected float price;

    public Product(int productId, String productName,float price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public void setPrice(float price) {
        this.price = price;
    }

    public void showProduct() {
        System.out.println("Product ID: "+productId+" - Product Name: "+productName+" - Price: "+
                price);
    }
}
