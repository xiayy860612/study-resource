package com.s2u2m.study.algorithm.tree.binary;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-inorder-traversal/">中序遍历</a>
 */
public class BinaryTreeInOrder {
    private static class TreeNode {
        public int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() { }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode cur, List<Integer> result) {
        if (cur == null) {
            return;
        }

        dfs(cur.left, result);
        result.add(cur.val);
        dfs(cur.right, result);
    }

    private void dfs2(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.addFirst(cur);
                cur = cur.left;
            }
            cur = stack.removeFirst();
            result.add(cur.val);
            cur = cur.right;
        }
    }

}
