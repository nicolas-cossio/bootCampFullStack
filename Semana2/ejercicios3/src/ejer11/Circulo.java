package ejercicios3.ejer11;

public class Circulo extends Figura{
    private float radio;
    final float PI = 3.1416f;

    public Circulo(String color, Boolean isFull, float radio) {
        super(color, isFull);
        this.radio = radio;
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    public float calcArea(){
        return PI*radio*radio;
    }

    public float calcPerimetro(){
        return 2*PI*radio;
    }

    @Override
    public void printColor() {
        if (getIsFull()) {
            System.out.println("Color: "+getColor());
        }
        else {
            System.out.println("El circulo no está relleno de ningún color.");
        }
    }
}
