package com.s2u2m.study.algorithm.tree;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/">树的后序遍历</a>
 */
public class TreePostOrder {
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

    public List<Integer> postorder(Node root) {
        List<Integer> result = new LinkedList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(Node cur, List<Integer> result) {
        if (cur == null) {
            return;
        }

        for (Node child : cur.children) {
            dfs(child, result);
        }
        result.add(cur.val);
    }

    private void dfs2(Node cur, LinkedList<Integer> result) {
        if (cur == null) {
            return;
        }
        Deque<Node> stack = new LinkedList<>();
        stack.addFirst(cur);
        while (!stack.isEmpty()) {
            Node node = stack.removeFirst();
            result.addFirst(node.val);
            for (Node child : node.children) {
                stack.addFirst(child);
            }
        }
    }
}