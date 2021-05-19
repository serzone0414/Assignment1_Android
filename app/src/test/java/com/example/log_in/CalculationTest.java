package com.example.log_in;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculationTest {

    Calculation testObj;
    Double weight, height;
    String birthday;
    int expectedAge, actualAge;
    double expectedBMI, actualBMI;

    @Before
    public void setUp() throws Exception {
        birthday = "14/04/1990";
        weight = Double.valueOf(81);
        height = Double.valueOf(171);
        testObj = new Calculation();
        actualBMI = testObj.bmiCalculator(weight,height);
        actualAge = testObj.ageCalculator(birthday);
        expectedAge = 31;
        expectedBMI = 27.7;

    }

    @After
    public void tearDown() throws Exception {
        testObj = null;
    }

    @Test
    public void ageCalculator() {
        assertEquals(expectedAge,actualAge);
    }

    @Test
    public void bmiCalculator() {
        assertEquals(expectedBMI,actualBMI,0.1);
    }
}