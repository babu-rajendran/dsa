package com.babu.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> greatestElementMap = new HashMap<>();
        Stack<Integer> elementStack = new Stack<>();

        for (Integer num : nums2) {
            while(!elementStack.isEmpty() && elementStack.peek() < num) {
                greatestElementMap.put(elementStack.pop(), num);
            }
            elementStack.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = greatestElementMap.getOrDefault(nums1[i], -1);
        }
        return nums1;

    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {7,10,8};
        int[] nums2 = new int[] {8, 7, 6, 5, 10};

        System.out.println(Arrays.toString(NextGreaterElement.nextGreaterElement(nums1, nums2)));
    }
}
