package com.babu;

import com.babu.leetcode.ListNode;
import com.babu.leetcode.MergeTwoSortedLists;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeTwoSortedListsTest {

    @Test
    public void testBruteForceSolution() {
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        node1.setNext(node3);
        node3.setNext(node5);

        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        node2.setNext(node4);

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode node = mergeTwoSortedLists.mergeTwoLists(node1, node2);
        List<Integer> intValues = new ArrayList<>();
        while (node != null) {
            intValues.add(node.getVal());
            node = node.getNext();
        }
        List<Integer> expectedValues = List.of(1, 2, 3, 4, 5);
        assertArrayEquals(intValues.toArray(), expectedValues.toArray());
    }
}
