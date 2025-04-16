package com.babu.ds;

import java.util.Scanner;

import java.util.*;

public class BSTVisualizer {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Insert node into BST
    static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else if (val > root.val) root.right = insert(root.right, val); // Ignore duplicates
        return root;
    }

    // Print tree like a diagram
    static void printTree(TreeNode root) {
        printTreeHelper(root, "", true);
    }

    static void printTreeHelper(TreeNode node, String prefix, boolean isTail) {
        if (node == null) return;

        if (node.right != null) {
            printTreeHelper(node.right, prefix + (isTail ? "│   " : "    "), false);
        }

        System.out.println(prefix + (isTail ? "└── " : "┌── ") + node.val);

        if (node.left != null) {
            printTreeHelper(node.left, prefix + (isTail ? "    " : "│   "), true);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode root = null;

        System.out.println("Enter integers to insert into BST (type 'done' to finish):");

        while (true) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("done")) break;
            try {
                int val = Integer.parseInt(input);
                root = insert(root, val);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer or 'done' to stop.");
            }
        }

        System.out.println("\nVisualized BST:");
        printTree(root);
    }
}

