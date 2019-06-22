package com.esurovskiy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TemperatureConverterTest {
    TemperatureConverter t;

    @Before
    public void init() {
        t = new TemperatureConverter();
    }

    @Test
    public void testConvertKtoC() {
        double res = t.convertKtoC(100);
        Assert.assertEquals(-173.15, res, 0.1);
    }
}
