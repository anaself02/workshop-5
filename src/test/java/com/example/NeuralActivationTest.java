package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NeuralActivationTest {

    NeuralActivation activation = new NeuralActivation();

    @Test
    void testNaNInput() {
        assertEquals(0.0, activation.process(Double.NaN, 0.01, 10));
    }

    @Test
    void testNegativeNoClipping() {
        double result = activation.process(-5, 0.1, 10);
        assertEquals(-0.5, result);
    }

    @Test
    void testNegativeWithClipping() {
        double result = activation.process(-200, 0.1, 10);
        assertEquals(-10, result);
    }

    @Test
    void testPositiveWithClipping() {
        double result = activation.process(20, 0.1, 10);
        assertEquals(10, result);
    }

    @Test
    void testPositiveNoClipping() {
        double result = activation.process(5, 0.1, 10);
        assertEquals(5, result);
    }
}
