package com.example.BinarySearchTree;

/**
 * 104. Maximum Depth of Binary Tree
 *
 * @author Steph
 * @date 2020/2/19 10:24
 */
public class Solution104 {
    /**
     * Recursion
     *
     * @param root 二叉树根结点
     * @return 最大深度
     */
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
