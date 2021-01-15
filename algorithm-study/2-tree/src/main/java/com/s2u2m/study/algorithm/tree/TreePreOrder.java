package com.s2u2m.study.algorithm.tree;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/submissions/">树的前序遍历</a>
 */
public class TreePreOrder {
    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> result = new LinkedList<>();
        dfs2(root, result);
        return result;
    }

    private void dfs(Node cur, List<Integer> result) {
        if (cur == null) {
            return;
        }

        result.add(cur.val);
        for (Node child : cur.children) {
            dfs(child, result);
        }
    }

    private void dfs2(Node cur, List<Integer> result) {
        if (cur == null) {
            return;
        }
        Deque<Node> stack = new LinkedList<>();
        stack.addFirst(cur);
        while (!stack.isEmpty()) {
            Node node = stack.removeFirst();
            result.add(node.val);
            Collections.reverse(node.children);
            for (Node child : node.children) {
                stack.addFirst(child);
            }
        }
    }
}