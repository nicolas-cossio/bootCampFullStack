package org.clasesGenericas;

public class Point2D<T extends Number> {
    T a;
    T b;

    public Point2D(T a, T b) {
        this.a = a;
        this.b = b;
    }

    public void print() {
        System.out.println("("+a+", "+b+")");
    }

    public T getA() {
        return a;
    }

    public T getB() {
        return b;
    }

    public Number suma() {
        if (a instanceof Integer) {
            return a.intValue() + b.intValue();
        }
        else if (a instanceof Float) {
            return a.floatValue() + b.floatValue();
        }
        return 0;
    }
}
