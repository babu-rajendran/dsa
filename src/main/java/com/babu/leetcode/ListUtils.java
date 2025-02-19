package com.babu.leetcode;

public final class ListUtils {

    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" --> ");
            }
            head = head.next;
        }
        System.out.println();
    }
}
