package com.pruebasUnitariasA.Impl;

import com.pruebasUnitariasA.Service.ServiceA;

public class ServiceAImpl implements ServiceA {
    @Override
    public int sumar(int a, int b) {
        return a+b;
    }
}
