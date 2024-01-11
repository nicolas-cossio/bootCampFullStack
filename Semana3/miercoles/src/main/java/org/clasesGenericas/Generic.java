package org.clasesGenericas;

import java.util.ArrayList;

public class Generic {
    public static void main(String[] args) {
        ArrayList<Integer> lista1 = new ArrayList<>();
        ArrayList<Integer> lista2 = new ArrayList<>();

        Point2D<Integer> punto = new Point2D<Integer>(2,3);
        Point2D<Float> punto2 = new Point2D<Float>(2.3f,3.7f);

        punto.print();
        punto2.print();

        System.out.println(punto.suma());
    }
}
