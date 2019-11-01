package com.han.leetcode.tree;

import com.han.leetcode.tree.util.TreeBuilder;
import com.han.leetcode.tree.util.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 `[3,9,20,null,null,15,7]` ,
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class ReverseLevelTraversal {
    public static void main(String[] args) {
        TreeNode<Integer> root = TreeBuilder.builder(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        System.out.println(new ReverseLevelTraversal().traversal(root).toString());
    }

    private List<List<Integer>> traversal(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> node = queue.poll();
                level.add(node.getValue());
                if (node.getLeft() != null)
                    queue.offer(node.getLeft());
                if (node.getRight() != null)
                    queue.offer(node.getRight());

            }

            result.add(level);
        }

        Collections.reverse(result);
        return result;
    }
}
