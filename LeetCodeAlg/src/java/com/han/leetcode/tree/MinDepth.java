package com.han.leetcode.tree;

import com.han.leetcode.tree.util.TreeBuilder;
import com.han.leetcode.tree.util.TreeNode;

/**
 * 给定一个二叉树，找出其最小深度。

 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

 说明: 叶子节点是指没有子节点的节点。

 示例:

 给定二叉树 `[3,9,20,null,null,15,7]` ,

 3
 / \
 9  20
 /  \
 15   7

 返回它的最小深度  2.
 */
public class MinDepth {

    public static void main(String[] args) {
        TreeNode<Integer> root = TreeBuilder.builder(new Integer[]{1, 2, 3,4,5,null,null,6});
        System.out.println(new MinDepth().depth(root));
    }

    private int depth(TreeNode<Integer> root){

        if(root == null)
            return 0;

        return Math.min(depth(root.getLeft()),depth(root.getRight()))+1;

    }
}
