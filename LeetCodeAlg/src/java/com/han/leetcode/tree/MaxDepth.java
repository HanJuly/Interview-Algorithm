package com.han.leetcode.tree;

import com.han.leetcode.tree.util.TreeBuilder;
import com.han.leetcode.tree.util.TreeNode;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 `[3,9,20,null,null,15,7]` ，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回它的最大深度 3 。
 */
public class MaxDepth {
    public static void main(String[] args) {
        TreeNode<Integer> root = TreeBuilder.builder(new Integer[]{1, 2, 3,null,null,null,null});
        System.out.println(new MaxDepth().max(root));
    }

    private int max(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }

        return Math.max(max(root.getLeft()), max(root.getRight()))+1 ;

    }
}
