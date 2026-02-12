package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

class NeuralActivationTest {

    private final NeuralActivation activator = new NeuralActivation();

    static Stream<Arguments> provideTestData() {
        return Stream.of(
            Arguments.of(Double.NaN, 0.01, 10.0, 0.0),
            Arguments.of(-2000.0, 0.01, 10.0, -10.0),
            Arguments.of(-1.0, 0.01, 10.0, -0.01),
            Arguments.of(15.0, 0.01, 10.0, 10.0),
            Arguments.of(5.0, 0.01, 10.0, 5.0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void testProcess(double x, double alpha, double limit, double expected) {
        assertEquals(expected, activator.process(x, alpha, limit), 0.0001);
    }
}