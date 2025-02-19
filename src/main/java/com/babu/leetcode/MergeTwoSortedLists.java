package com.babu.leetcode;

/**
 * <a href="https://leetcode.com/problems/merge-two-sorted-lists/">Merge Two Sorted Lists</a>
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 *
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 *
 */

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode dummy = new ListNode(-111);
        ListNode newHead = dummy;

        while (true) {
            if (list2 == null) {
                dummy.next = list1;
                break;
            } else if (list1 == null) {
                dummy.next = list2;
                break;
            } else if (list1.val <= list2.val) {
                dummy.next = list1;
                list1 = list1.next;
                dummy = dummy.next;
            } else {
                dummy.next = list2;
                list2 = list2.next;
                dummy = dummy.next;
            }
        }
        return newHead.next;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        node1.next = node3;
        node3.next = node5;

        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        node2.next = node4;

        System.out.println("Original List: ");
        ListUtils.printLinkedList(node1);
        ListUtils.printLinkedList(node2);

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode mergedList = mergeTwoSortedLists.mergeTwoLists(node1, node2);

        System.out.println("Merged List: ");
        ListUtils.printLinkedList(mergedList);
    }

}
