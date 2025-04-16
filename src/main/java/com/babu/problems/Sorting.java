package com.babu.problems;

import java.util.Arrays;

public class Sorting {

    public static void sortArray(int[] nums) {
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        int[] data = {5, 1, 4, 2, 8};
        // Sorting.sortArray(data);
        // Sorting.bubbleSort(data);
        // System.out.println(Arrays.toString(data));
        System.out.println(Sorting.isSorted(data));
        Sorting.sortArray(data);
        System.out.println(Sorting.isSorted(data));
        String[] words = {"banana", "apple", "cherry"};
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));
        int[] colors = {2,0,2,1,1,0};
        Sorting.sortColors(colors);
        System.out.println(Arrays.toString(colors));
    }

    static boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                return false;
            }
        }
        return true;
    }

    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

}
