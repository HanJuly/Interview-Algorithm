package com.han.leetcode.tree;

import com.han.leetcode.tree.util.TreeBuilder;
import com.han.leetcode.tree.util.TreeNode;

public class SameTree {

    public static void main(String[] args) {
        TreeNode<Integer> p = TreeBuilder.builder(new Integer[]{4, 2, 7, 1, 3,7,9});
        TreeNode<Integer> q = TreeBuilder.builder(new Integer[]{10, 2, 7, 1, 3,7,9});
        System.out.println(new SameTree().isSameTree(p,q));
    }

    public boolean isSameTree(TreeNode<Integer> p, TreeNode<Integer> q) {
        if (p == null || q == null) {
            return p == q;
        }

        return p.getValue().equals(q.getValue()) && isSameTree(p.getLeft(), q.getLeft()) && isSameTree(p.getRight(), q.getRight());
    }
}
