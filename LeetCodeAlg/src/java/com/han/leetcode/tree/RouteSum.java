package com.han.leetcode.tree;

import com.han.leetcode.tree.util.TreeBuilder;
import com.han.leetcode.tree.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 `sum = 22` ，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * <p>
 * 返回 `true` , 因为存在目标和为 22 的根节点到叶子节点的路径 `5->4->11->2` 。
 *
 * 1.从上至下递减目标值
 * 2.在递归方法最后一行remove做回溯
 */
public class RouteSum {
    private static List<List<Integer>> allPaths = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode<Integer> root = TreeBuilder.builder(new Integer[]{1, 2, 3, 4, 5, null, null, 6,null,5});
        new RouteSum().route(root, 13);
        System.out.println(allPaths);
    }

    private void route(TreeNode<Integer> root, int sum) {
        List<Integer> path = new ArrayList<>();
        walk(root, sum, path);
    }

    private void walk(TreeNode<Integer> root, int sum, List<Integer> path) {
        path.add(root.getValue());




        if (root.getLeft() != null)
            walk(root.getLeft(), sum - root.getValue(), path);
        if (root.getRight() != null)
            walk(root.getRight(), sum - root.getValue(), path);

        if (root.getLeft() == null && root.getRight() == null) {
            if (sum == root.getValue())
                allPaths.add(new ArrayList<>(path));
        }
        path.remove(path.size() - 1);
    }
}
