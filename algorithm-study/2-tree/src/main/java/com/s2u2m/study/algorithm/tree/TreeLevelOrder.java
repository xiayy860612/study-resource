package com.s2u2m.study.algorithm.tree;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/">树的层次遍历</a>
 */
public class TreeLevelOrder {
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

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new LinkedList<>();
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> cur = new LinkedList<>();
            while (size-- != 0) {
                Node node = queue.removeFirst();
                cur.add(node.val);
                for (Node child : node.children) {
                    queue.addLast(child);
                }
            }
            result.add(cur);
        }
        return result;
    }

}