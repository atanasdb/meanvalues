package org.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MeanTest {
    @Test(expected = IllegalArgumentException.class)
    public void nullMeanThrows()  {
        new Mean(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyMeanThrows()  {
       new Mean(new int[]{});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidOrderBoundaries()  {
        final Mean m = new Mean(new int[]{1, 1, 2, 3, 1, 4});
        m.getMean(2, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidBoundariesL()  {
        final Mean m = new Mean(new int[]{1, 1, 2, 3, 1, 4});
        m.getMean(6, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidBoundariesR()  {
        final Mean m = new Mean(new int[]{1, 1, 2, 3, 1, 4});
        m.getMean(2, 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeBoundaries()  {
        final Mean m = new Mean(new int[]{1, 1, 2, 3, 1, 4});
        m.getMean(-2, 2);
    }

    @Test
    public void singleElementMean()  {
        final Mean m = new Mean(new int[]{3});
        assertEquals(m.getMean(0, 0), 3, 1e-15);
    }

    @Test
    public void testBegSlice()  {
        final Mean m = new Mean(new int[]{1, 1, 2, 3, 1, 4});
        assertEquals(m.getMean(0, 1), 1, 1e-15);
    }

    @Test
    public void testMean()  {
        final Mean m = new Mean(new int[]{1, 1, 2, 3, 1, 4});
        assertEquals(m.getMean(2, 3), 2.5f, 1e-15);
    }
}
