package org.example;

public class Mean {
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
