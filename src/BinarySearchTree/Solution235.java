package BinarySearchTree;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 *
 * @author Steph
 * @date 2020/2/19 10:29
 */
public class Solution235 {
    /**
     * Recursion
     * Note: 对于BST, 可以通过比较结点的值来做出判断
     * @param root 二叉搜索树根结点
     * @param p    结点p
     * @param q    结点q
     * @return 最小公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        else if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
