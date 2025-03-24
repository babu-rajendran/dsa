package com.babu.leetcode;

import com.babu.ds.linkedlist.TreeNode;

class TreeDiameter {
    public int globalMax = 0;

    public int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = calculateHeight(node.getLeft());
        int rightHeight = calculateHeight(node.getRight());

        globalMax = Math.max(globalMax, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight,rightHeight);
    }

    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }
        calculateHeight(root);

        return globalMax;
    }
}