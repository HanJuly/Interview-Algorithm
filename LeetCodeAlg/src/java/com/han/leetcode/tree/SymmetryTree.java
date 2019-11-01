package com.han.leetcode.tree;

import com.han.leetcode.tree.util.TreeBuilder;
import com.han.leetcode.tree.util.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 `[1,2,2,3,4,4,3]` 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 `[1,2,2,null,3,null,3]` 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class SymmetryTree {

    public static void main(String[] args) {
        TreeNode<Integer> root = TreeBuilder.builder(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        System.out.println(new SymmetryTree().isSymmetry(root));
    }

    private boolean isSymmetry(TreeNode<Integer> root){
        if(root == null)
            return false;
        return isSymmetry(root.getLeft(),root.getRight());
    }

    private boolean isSymmetry(TreeNode<Integer> left,TreeNode<Integer> right){
        if(left == null || right == null)
            return left == right;

        return left.getValue().equals(right.getValue()) && isSymmetry(left.getLeft(),right.getRight()) && isSymmetry(left.getRight(),right.getLeft());
    }
}
