package com.han.leetcode.tree;

import com.han.leetcode.tree.util.TreeBuilder;
import com.han.leetcode.tree.util.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * > 一个二叉树 _每个节点_ 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 `[3,9,20,null,null,15,7]`
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回 `true` 。
 *
 * 示例 2:
 *
 * 给定二叉树 `[1,2,2,3,3,null,null,4,4]`
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 *
 * 返回 `false` 。
 */
public class BalanceTree {
    public static void main(String[] args) {
        TreeNode<Integer> root = TreeBuilder.builder(new Integer[]{1, 2, 3,null,null,null,null});
        System.out.println(new BalanceTree().max(root));
    }

    private int depth(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }

        return depth(root.getLeft())+1 - depth(root.getRight())+1  ;

    }
}
