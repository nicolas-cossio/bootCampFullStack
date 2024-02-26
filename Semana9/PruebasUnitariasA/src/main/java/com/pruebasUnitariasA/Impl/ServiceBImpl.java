package com.pruebasUnitariasA.Impl;

import com.pruebasUnitariasA.Service.ServiceA;
import com.pruebasUnitariasA.Service.ServiceB;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServiceBImpl implements ServiceB {
    private final ServiceA serviceA;

    @Override
    public int multiplicarSumar(int a, int b, int multiplicador) {
        return multiplicar(serviceA.sumar(a,b),multiplicador);
    }

    @Override
    public int multiplicar(int a, int b) {
        return a*b;
    }
}
