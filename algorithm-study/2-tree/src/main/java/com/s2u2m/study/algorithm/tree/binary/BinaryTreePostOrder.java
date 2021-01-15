package com.s2u2m.study.algorithm.tree.binary;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-postorder-traversal/">后序遍历</a>
 */
public class BinaryTreePostOrder {
    private static class TreeNode {
        public int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode cur, List<Integer> result) {
        if (cur == null) {
            return;
        }

        dfs(cur.left, result);
        dfs(cur.right, result);
        result.add(cur.val);
    }

    private void dfs2(TreeNode root, LinkedList<Integer> result) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.removeFirst();
            result.addFirst(node.val);

            if (node.left != null) {
                stack.addFirst(node.left);
            }

            if (node.right != null) {
                stack.addFirst(node.right);
            }
        }
    }
}