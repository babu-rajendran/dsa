package com.babu.ds.linkedlist;

import java.util.Scanner;

public class ListNode {
    ListNode next;
    int value;

    ListNode() {

    }

    ListNode(int value) {
        this.value = value;
    }

    ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;

        System.out.println("Original List: ");
        printLinkedList(node1);

        ListNode newHead = reverseLinkedList(node1);
        System.out.println("Reversed List: ");
        printLinkedList(newHead);

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println("Original List: ");
        printLinkedList(n1);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the positions to reverse between 1 and 5:");
        int firstPosition = scanner.nextInt();
        int secondPosition = scanner.nextInt();

        ListNode result = reverseBetween(n1, firstPosition, secondPosition);
        System.out.println("Reversed List between positions " + firstPosition + " and " + secondPosition);
        printLinkedList(result);

    }

    public static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        // Step 1: Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 2: Move `prev` to the node just before `left`
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 3: Start reversing from `left`
        ListNode curr = prev.next;
        ListNode next = null;
        // Step 4: Reverse nodes from `left` to `right`
        for (int i = 0; i < right - left; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummy.next;

    }

    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.value);
            if (head.next != null) {
                System.out.print(" --> ");
            }
            head = head.next;
        }
        System.out.println();
    }

}
