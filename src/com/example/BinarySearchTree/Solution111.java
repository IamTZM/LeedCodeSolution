package com.example.BinarySearchTree;

/**
 * 111. Minimum Depth of Binary Tree
 *
 * @author Steph
 * @date 2020/2/19 10:25
 */
public class Solution111 {
    /**
     * Recursion
     *
     * @param root 二叉树根结点
     * @return 最小深度
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0)
                ? 1 + left + right
                : 1 + Math.min(left, right);
    }
}
