package com.abhinay;

import org.junit.Test;

public class CalcTest {
    @Test
    void divideTest(){
        Calc c = new Calc();
        int result = c.divide(10,2);
        int expected = 5;

        assertEquals(expected, result);
    }
}
