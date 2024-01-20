package ejercicios3.ejer11;

public abstract class Figura {
    protected String color;
    protected Boolean isFull;

    public Figura(String color, Boolean isFull) {
        this.color = color;
        this.isFull = isFull;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getIsFull() {
        return isFull;
    }

    public void setIsFull(Boolean isFull) {
        this.isFull = isFull;
    }

    public void printColor() {
        System.out.println(color);
    }

    public abstract float calcArea();

    public abstract float calcPerimetro();


}
