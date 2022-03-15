package org.example;

/**
 * Class suitable for calculating mean value of different slices of a constant array multiple times
 */
public class Mean {
    /**
     * Constructor
     * @param elements The constant array
     * @throws IllegalArgumentException if array is null or empty
     */
    public Mean(final int[] elements) {
        if (elements == null || elements.length == 0) {
            throw new IllegalArgumentException("empty list");
        }
        preCalcSums = new int[elements.length];
        preCalcSums[0] = elements[0];
        for (int i = 1; i < elements.length; i++) {
            preCalcSums[i] = preCalcSums[i - 1] + elements[i];
        }
    }

    /**
     * Gets the mean value of the slice
     * @param l Left boundary of the slice
     * @param r Right boundary of the slice
     * @return The mean value
     * @throws IllegalArgumentException in case of out of boundary slice indexes
     */
    public double getMean(int l, int r) {
        if (!((l >= 0) && (r >= 0) && (l <= r ) && (l < preCalcSums.length) && (r < preCalcSums.length))) {
            throw new IllegalArgumentException("illegal slice");
        }
        final int sliceSum = preCalcSums[r] - (l > 0 ? preCalcSums[l - 1] : 0);
        final double mean = (double)sliceSum / (double)(r - l + 1);
        return mean;
    }

    private final int[] preCalcSums;
}
