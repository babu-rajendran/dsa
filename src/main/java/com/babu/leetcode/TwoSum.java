package com.babu.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://leetcode.com/problems/two-sum/">Two Sum</a>
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 *
 *
 * Follow-up: Can you come up with an algorithm that is less than O(n2) time
 * complexity?
 *
 */

public class TwoSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the input array as a comma-separated string
        System.out.print("Enter the array elements (comma-separated): ");
        String input = scanner.nextLine();
        String[] tokens = input.split(",");

        // Convert the string array to an integer array
        int[] nums = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            nums[i] = Integer.parseInt(tokens[i].trim());
        }

        // Read the target integer
        System.out.print("Enter the target: ");
        int target = scanner.nextInt();

        TwoSum twoSum = new TwoSum();
        System.out.println("Input array: " + Arrays.toString(nums) + " with target " + target);
        System.out.println("Using Brute Force: ");
        for (int i : twoSum.bruteForceSolution(nums, target)) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Using HashMap: ");
        for (int i : twoSum.hashMapSolution(nums, target)) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Using Two Pointers: ");
        for (int i : twoSum.sortedArraySolution(nums, target)) {
            System.out.print(i + " ");
        }
    }

    // Time complexity: O(n2)
    // Space complexity: O(1)
    public int[] bruteForceSolution(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j ++) {
                if (nums[i] + nums[j]  == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int[] hashMapSolution(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(target - nums[i])) {
                return new int[] {numMap.get(target - nums[i]), i};
            } else {
                numMap.put(nums[i], i);
            }
        }
        return null;
    }

    public int[] sortedArraySolution(int[] nums, int target) {
        for (int i = 0, j = nums.length - 1; i <= j;) {
            int targetSum = nums[i] + nums[j];
            if (targetSum == target) {
                return new int[] {i, j};
            } else if (targetSum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

}
