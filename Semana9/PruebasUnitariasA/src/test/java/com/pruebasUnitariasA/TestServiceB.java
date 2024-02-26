package com.pruebasUnitariasA;

import com.pruebasUnitariasA.Impl.ServiceAImpl;
import com.pruebasUnitariasA.Impl.ServiceBImpl;
import com.pruebasUnitariasA.Service.ServiceA;
import com.pruebasUnitariasA.Service.ServiceB;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class TestServiceB {
    ServiceA serviceA = new ServiceAImpl();
    ServiceB serviceB = new ServiceBImpl(serviceA);

    @Test
    public void testMultiplicar() {
        Assert.assertEquals(serviceB.multiplicar(4,5), 20);
    }

    @Test
    public void testMultiplicarSumar() {
        Assert.assertEquals(serviceB.multiplicarSumar(2,2,5), 20);
    }

    // Mockito crea modelos hardcodeados
    @Test
    public void testMultiplicarSumarMockito() {
        ServiceA serviceA1 = Mockito.mock(ServiceA.class);
        Mockito.when(serviceA1.sumar(8,6)).thenReturn(20);

        ServiceB serviceB1 = new ServiceBImpl(serviceA1);
        Assert.assertEquals(serviceB1.multiplicarSumar(8,6,5), 100);
    }
}
