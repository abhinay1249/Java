package com.abhinay;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class CalcTest {
    
    @Test

    void divideTest(){
        Calc calc = new Calc();
        int result = calc.divide(10,2);
        int expected = 5;

        assertEquals(expected, result);
    }
}
