package com.s2u2m.study.algorithm.tree.binary;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

import com.s2u2m.study.algorithm.tree.TreePostOrder;

public class BinaryTreePreOrder {
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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        dfs2(root, result);
        return result;
    }

    private void dfs(TreeNode cur, List<Integer> result) {
        if (cur == null) {
            return;
        }

        result.add(cur.val);
        dfs(cur.left, result);
        dfs(cur.right, result);
    }

    private void dfs2(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.removeFirst();
            result.add(node.val);
            if (node.right != null) {
                stack.addFirst(node.right);
            }

            if (node.left != null) {
                stack.addFirst(node.left);
            }
        }
    }
}
