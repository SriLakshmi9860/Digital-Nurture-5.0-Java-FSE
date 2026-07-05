package com.cognizant;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorAAATest {

    private Calculator calculator;

    @Before
    public void setUp() {
        // Arrange
        calculator = new Calculator();
        System.out.println("Setup completed");
    }

    @After
    public void tearDown() {
        System.out.println("Teardown completed");
    }

    @Test
    public void testAddition() {

        // Act
        int result = calculator.add(10, 20);

        // Assert
        assertEquals(30, result);
    }

    @Test
    public void testMultiplication() {

        // Act
        int result = calculator.multiply(5, 4);

        // Assert
        assertEquals(20, result);
    }
}