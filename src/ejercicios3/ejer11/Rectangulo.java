package ejercicios3.ejer11;

public class Rectangulo extends Figura{
    private float ancho;
    private float altura;

    public Rectangulo(String color, Boolean isFull, float ancho, float altura) {
        super(color, isFull);
        this.ancho = ancho;
        this.altura = altura;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float calcArea(){
        return ancho*altura;
    }

    public float calcPerimetro(){
        return ancho*2+altura*2;
    }

    @Override
    public void printColor() {
        if (getIsFull()) {
            System.out.println("Color: "+getColor());
        }
        else {
            System.out.println("El rectangulo no está relleno de ningún color.");
        }
    }
}
