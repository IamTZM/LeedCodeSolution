package com.example.BinarySearchTree;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 *
 * @author Steph
 * @date 2020/2/19 10:42
 */
public class Solution236 {
    /**
     * Recursion
     * Note: 不能通过结点的值来判断
     * @param root 二叉树根结点
     * @param p 结点p
     * @param q 结点q
     * @return 最小公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }
}
