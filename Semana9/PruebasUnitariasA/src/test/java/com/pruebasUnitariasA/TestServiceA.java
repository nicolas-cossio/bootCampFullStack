package com.pruebasUnitariasA;

import com.pruebasUnitariasA.Impl.ServiceAImpl;
import com.pruebasUnitariasA.Service.ServiceA;
import org.junit.Assert;
import org.junit.Test;

public class TestServiceA {
    @Test
    public void testSumar() {
        ServiceA serviceA = new ServiceAImpl();
        Assert.assertEquals(serviceA.sumar(3,4), 7);
    }
}
