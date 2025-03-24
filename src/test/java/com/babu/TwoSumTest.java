package com.babu;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.babu.leetcode.TwoSum;
import org.junit.jupiter.api.Test;

/**
 * Unit test for Two Sum.
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

    static int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args) {
        int n = 6;

        int i = 0;
        int j = 1;

        int total = 1;

        System.out.println(i);
        System.out.println(j);

        int count = 5;

        while (count - 2 <= n) {
            int k = i + j;
            total+=k;
            System.out.println(k);
            i = j;
            j = k;
            count++;
        }
        System.out.println(total);

        System.out.println("Recursive: " + fib(n));
    }

}
