package ejercicios3.ejer11;

public class Principal {
    public static void main(String[] args) {
        Figura circ = new Circulo("Azul", false, 4);
        Figura rect = new Rectangulo("Verde", false, 5,3);
        Figura triangulo = new Triangulo("Rojo", false, 3,4,3);

        circ.setIsFull(true);
        rect.setIsFull(false);

        System.out.println("Rectángulo: ");
        System.out.println("Lados: "+ ((Rectangulo) rect).getAncho()+" , "+ ((Rectangulo) rect).getAltura());
        System.out.println("Area: "+rect.calcArea());
        System.out.println("Perimetro: "+rect.calcPerimetro());
        rect.printColor();
        System.out.println();

        System.out.println("Circulo: ");
        System.out.println("Radio: "+((Circulo) circ).getRadio());
        System.out.println("Area: "+circ.calcArea());
        System.out.println("Perimetro: "+circ.calcPerimetro());
        circ.printColor();
        System.out.println();

//        System.out.println("Triángulo: ");
//        System.out.println("Area: "+triangulo.calcArea());
//        System.out.println("Perimetro: "+triangulo.calcPerimetro());
    }
}
