package com.babu;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.babu.leetcode.TwoSum;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class TwoSumTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testBruteForceSolution() {
        int[] nums = new int[] {3, 3};
        TwoSum twoSum = new TwoSum();
        int[] solution = twoSum.bruteForceSolution(nums, 6);
        assertArrayEquals(new int[] {0, 1}, solution);
    }

    @Test
    public void testHashMapSolution() {
        int[] nums = new int[] {3, 3};
        TwoSum twoSum = new TwoSum();
        int[] solution = twoSum.hashMapSolution(nums, 6);
        assertArrayEquals(new int[] {0, 1}, solution);
    }
}
