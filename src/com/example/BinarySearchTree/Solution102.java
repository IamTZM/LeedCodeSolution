package com.example.BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 *
 * @author Steph
 * @date 2020/2/19 10:20
 */
public class Solution102 {
    /**
     * BFS模板
     * @param root 输入二叉树根结点
     * @return 层序遍历结果
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int queue_len = queue.size();
            List<Integer> level_list = new ArrayList<>();
            for (int i = 0; i < queue_len; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
                level_list.add(tmp.val);
            }
            result.add(level_list);
        }

        return result;
    }
}
