package com.example;

public class NeuralActivation {

    /**
     * Processes a raw activation value using a Clipped Leaky ReLU logic.
     *
     * @param x The raw input (dot product of weights and inputs + bias)
     * @param alpha The leak factor for negative values (e.g., 0.01)
     * @param limit The maximum absolute value allowed (prevents exploding gradients)
     * @return The processed activation
     */
    public double process(double x, double alpha, double limit) {

        // Safety check for invalid numerical input
        if (Double.isNaN(x)) {
            return 0.0;
        }

        // Negative branch
        if (x < 0) {
            double val = x * alpha;

            // Lower bound clipping
            if (val < -limit) {
                return -limit;
            }

            return val;
        } 
        // Positive branch
        else {

            // Upper bound clipping
            if (x > limit) {
                return limit;
            }

            return x;
        }
    }
}
