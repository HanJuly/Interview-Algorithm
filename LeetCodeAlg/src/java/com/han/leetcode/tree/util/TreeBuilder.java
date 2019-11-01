package com.han.leetcode.tree.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class
TreeBuilder {

    public static <T> TreeNode<T> builder(T[] val) {
        TreeNode<T> root = new TreeNode<T>();
        root.setValue(val[0]);
        builderNode(root, val, 0);
        return root;
    }

    private static <T> void builderNode(TreeNode<T> root, T[] val, int index) {

        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        TreeNode<T> right = null;
        TreeNode<T> left = null;
        if (leftIndex < val.length && val[leftIndex] != null) {
            left = new TreeNode<T>();
            left.setValue(val[leftIndex]);
        }

        if (rightIndex < val.length && val[rightIndex] != null) {
            right = new TreeNode<T>();
            right.setValue(val[rightIndex]);
        }

        if (leftIndex >= val.length && rightIndex >= val.length) {
            if (root != null) {
                System.out.println(String.format("到达叶子节点 [%s].....", root.getValue()));
            }
            return;
        }


        root.setLeft(left);
        root.setRight(right);
        builderNode(left, val, leftIndex);
        builderNode(right, val, rightIndex);
    }


    private static <T> List<List<T>> traversal(TreeNode<T> root) {
        Queue<TreeNode<T>> queue = new LinkedList<>();
        List<List<T>> result = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<T> level = new ArrayList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode<T> node = queue.poll();
                level.add(node.getValue());
                if (node.getLeft() != null)
                    queue.offer(node.getLeft());
                if (node.getRight() != null)
                    queue.offer(node.getRight());

            }

            result.add(level);
        }
        return result;
    }

    public static <T> void lookThrough(TreeNode<T> root) {
        List<List<T>> res = traversal(root);
        for (List<T> re : res) {
            for (T t : re) {
                System.out.print(t +" - ");
            }
            System.out.println("");
        }
    }

    public static <T> void lookThrough(TreeNode<T> root, int bottomNodes) {
        int wdith = bottomNodes + 1;
        System.out.print(root.getValue());
        System.out.println();
        lookThrough(root.getLeft(),bottomNodes/2);
        lookThrough(root.getRight(),bottomNodes/2);

    }


}
