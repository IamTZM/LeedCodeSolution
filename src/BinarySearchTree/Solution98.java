package BinarySearchTree;

/**
 * 98. Validate Binary Search Tree
 *
 * @author Steph
 * @date 2020/2/19 10:16
 */
public class Solution98 {
    private boolean flag;
    private long pre;

    public boolean isValidBST(TreeNode root) {
        flag = true;
        pre = Long.MIN_VALUE;
        helper(root);
        return flag;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (root.val <= pre) {
            flag = false;
            return;
        }
        pre = root.val;
        helper(root.right);
    }
}
/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
