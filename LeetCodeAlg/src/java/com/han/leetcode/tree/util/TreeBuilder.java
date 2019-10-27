package com.han.leetcode.tree.util;

public class TreeBuilder {

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
        if (leftIndex < val.length) {
            left = new TreeNode<T>();
            left.setValue(val[leftIndex]);
        }

        if (rightIndex < val.length) {
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


    public static <T> void lookThrough(TreeNode<T> root) {
        if (root == null)
            return;
        if (root.getLeft() != null)
            System.out.println(root.getLeft().getValue().toString());
        if (root.getRight() != null)
            System.out.println(root.getRight().getValue().toString());

        if (root.getRight() == null && root.getLeft() == null)
            return;
        lookThrough(root.getLeft());
        lookThrough(root.getRight());
    }
}
