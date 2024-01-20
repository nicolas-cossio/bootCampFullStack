package ejercicios3.ejer11;

public class Triangulo extends Figura{
    private float longA;
    private float longB;
    private float longC;

    public Triangulo(String color, Boolean isFull, float longA, float longB, float longC) {
        super(color, isFull);
        this.longA = longA;
        this.longB = longB;
        this.longC = longC;
    }

    public float getLongA() {
        return longA;
    }

    public void setLongA(float longA) {
        this.longA = longA;
    }

    public float getLongB() {
        return longB;
    }

    public void setLongB(float longB) {
        this.longB = longB;
    }

    public float getLongC() {
        return longC;
    }

    public void setLongC(float longC) {
        this.longC = longC;
    }

    public float calcPerimetro(){
        return longA+longB+longC;
    }

    public float calcArea(){
        float s = calcPerimetro() /2;
        float area = s*(s-longA)*(s-longB)*(s-longC);
        return (float) Math.sqrt(area);
    }

    @Override
    public void printColor() {
        if (getIsFull()) {
            System.out.println("Color: "+getColor());
        }
        else {
            System.out.println("El triángulo no está relleno de ningún color.");
        }
    }
}
